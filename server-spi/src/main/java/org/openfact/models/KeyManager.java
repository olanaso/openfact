/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.models;

import org.openfact.keys.KeyMetadata;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public interface KeyManager {

    ActiveKey getActiveKey(OrganizationModel organization);

    PublicKey getPublicKey(OrganizationModel organization, String kid);

    Certificate getCertificate(OrganizationModel organization, String kid);

    List<KeyMetadata> getKeys(OrganizationModel organization, boolean includeDisabled);

    class ActiveKey {
        private final String kid;
        private final PrivateKey privateKey;
        private final PublicKey publicKey;
        private final X509Certificate certificate;

        public ActiveKey(String kid, PrivateKey privateKey, PublicKey publicKey,
                         X509Certificate certificate) {
            this.kid = kid;
            this.privateKey = privateKey;
            this.publicKey = publicKey;
            this.certificate = certificate;
        }

        public String getKid() {
            return kid;
        }

        public PrivateKey getPrivateKey() {
            return privateKey;
        }

        public PublicKey getPublicKey() {
            return publicKey;
        }

        public X509Certificate getCertificate() {
            return certificate;
        }
    }

}
