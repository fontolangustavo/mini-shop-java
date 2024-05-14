package br.com.iteris.itc.minishop.core.types;

public enum UserEnum {
    CUSTOMER("customer");
    private final String type;

    UserEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}