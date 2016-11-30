/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models;

import java.util.Collections;
import java.util.Map;

public abstract class UserSenderModel implements UserModel {

    public String getUsername() {
        return null;
    }

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }

    public boolean hasRole(String role) {
        return false;
    }
    
    public Map<String, Object> getAttributes() {
        return Collections.emptyMap();
    }

}