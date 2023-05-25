package com.example.geektrust.constants;

public enum Plan {
    FREE_PLAN("FREE"),
    PERSONAL_PLAN("PERSONAL"),
    PREMIUM_PLAN("PREMIUM");

    private final String value;

    Plan(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


