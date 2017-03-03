package org.openfact.keys;

import org.keycloak.common.util.CertificateUtils;
import org.keycloak.common.util.KeyUtils;
import org.keycloak.common.util.PemUtils;
import org.openfact.keys.qualifiers.*;
import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentModel;
import org.openfact.models.component.ComponentValidationException;
import org.openfact.models.provider.ProviderConfigProperty;
import org.openfact.provider.ConfigurationValidationHelper;

import javax.ejb.Stateless;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.List;

@Stateless
@QComponentProvider(providerType = KeyProvider.class)
@QRsaKeyProvider(type = RsaKeyType.IMPORTED)
public class ImportedRsaKeyProviderFactory extends AbstractRsaKeyProviderFactory implements RsaKeyProviderFactory {

    public static final String ID = "rsa";

    private static final String HELP_TEXT = "RSA key provider that can optionally generated a self-signed certificate";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractRsaKeyProviderFactory.configurationBuilder()
            .property(Attributes.PRIVATE_KEY_PROPERTY)
            .property(Attributes.CERTIFICATE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(OrganizationModel organization, ComponentModel model) {
        return new ImportedRsaKeyProvider(organization, model);
    }

    @Override
    public void validateConfiguration(OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
        super.validateConfiguration(organization, model);

        ConfigurationValidationHelper.check(model)
                .checkSingle(Attributes.PRIVATE_KEY_PROPERTY, true)
                .checkSingle(Attributes.CERTIFICATE_PROPERTY, false);

        KeyPair keyPair;
        try {
            PrivateKey privateKey = PemUtils.decodePrivateKey(model.get(Attributes.PRIVATE_KEY_KEY));
            PublicKey publicKey = KeyUtils.extractPublicKey(privateKey);
            keyPair = new KeyPair(publicKey, privateKey);
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to decode private key", t);
        }

        if (model.contains(Attributes.CERTIFICATE_KEY)) {
            Certificate certificate = null;
            try {
                certificate = PemUtils.decodeCertificate(model.get(Attributes.CERTIFICATE_KEY));
            } catch (Throwable t) {
                throw new ComponentValidationException("Failed to decode certificate", t);
            }

            if (certificate == null) {
                throw new ComponentValidationException("Failed to decode certificate");
            }

            if (!certificate.getPublicKey().equals(keyPair.getPublic())) {
                throw new ComponentValidationException("Certificate does not match private key");
            }
        } else {
            try {
                Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organization.getName());
                model.put(Attributes.CERTIFICATE_KEY, PemUtils.encodeCertificate(certificate));
            } catch (Throwable t) {
                throw new ComponentValidationException("Failed to generate self-signed certificate");
            }
        }
    }

    @Override
    public String getHelpText() {
        return HELP_TEXT;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return CONFIG_PROPERTIES;
    }

}
