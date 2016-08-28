package org.openfact.jose.jws;

import org.openfact.jose.jws.crypto.RSAProvider;
import org.openfact.jose.jws.crypto.SignatureProvider;

public enum Algorithm {

    none(null),
    HS256(null),
    HS384(null),
    HS512(null),
    RS256(new RSAProvider()),
    RS384(new RSAProvider()),
    RS512(new RSAProvider()),
    ES256(null),
    ES384(null),
    ES512(null)
    ;
    private SignatureProvider provider;

    Algorithm(SignatureProvider provider) {
        this.provider = provider;
    }

    public SignatureProvider getProvider() {
        return provider;
    }
}
