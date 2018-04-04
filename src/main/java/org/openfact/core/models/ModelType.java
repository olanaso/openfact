package org.openfact.core.models;

public enum ModelType {

    COMPANY("company");

    private String alias;

    ModelType(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}