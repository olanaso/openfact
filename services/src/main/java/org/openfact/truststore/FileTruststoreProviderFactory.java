package org.openfact.truststore;

import org.jboss.logging.Logger;
import org.openfact.Config;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;

public class FileTruststoreProviderFactory implements TruststoreProviderFactory {

    private static final Logger log = Logger.getLogger(FileTruststoreProviderFactory.class);

    private TruststoreProvider provider;

    @Override
    public TruststoreProvider create(OpenfactSession session) {
        return provider;
    }

    @Override
    public void init(Config.Scope config) {

        String storepath = config.get("file");
        String pass = config.get("password");
        String policy = config.get("hostname-verification-policy");
        Boolean disabled = config.getBoolean("disabled", null);

        // if "truststore" . "file" is not configured then it is disabled
        if (storepath == null && pass == null && policy == null && disabled == null) {
            return;
        }

        // if explicitly disabled
        if (disabled != null && disabled) {
            return;
        }

        HostnameVerificationPolicy verificationPolicy = null;
        KeyStore truststore = null;

        if (storepath == null) {
            throw new RuntimeException("Attribute 'file' missing in 'truststore':'file' configuration");
        }
        if (pass == null) {
            throw new RuntimeException("Attribute 'password' missing in 'truststore':'file' configuration");
        }

        try {
            truststore = loadStore(storepath, pass == null ? null :pass.toCharArray());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize TruststoreProviderFactory: " + new File(storepath).getAbsolutePath(), e);
        }
        if (policy == null) {
            verificationPolicy = HostnameVerificationPolicy.WILDCARD;
        } else {
            try {
                verificationPolicy = HostnameVerificationPolicy.valueOf(policy);
            } catch (Exception e) {
                throw new RuntimeException("Invalid value for 'hostname-verification-policy': " + policy + " (must be one of: ANY, WILDCARD, STRICT)");
            }
        }

        provider = new FileTruststoreProvider(truststore, verificationPolicy);
        TruststoreProviderSingleton.set(provider);
        log.debug("File trustore provider initialized: " + new File(storepath).getAbsolutePath());
    }

    private KeyStore loadStore(String path, char[] password) throws Exception {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = new FileInputStream(path);
        try {
            ks.load(is, password);
            return ks;
        } finally {
            try {
                is.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "file";
    }
}