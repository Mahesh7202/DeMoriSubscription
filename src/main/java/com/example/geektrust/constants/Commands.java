package com.example.geektrust.constants;

public enum Commands{
    START_SUBSCRIPTION("START_SUBSCRIPTION"),
    ADD_SUBSCRIPTION("ADD_SUBSCRIPTION"),
    ADD_TOPUP("ADD_TOPUP"),
    INVALID_DATE("INVALID_DATE"),
    PRINT_RENEWAL_DETAILS("PRINT_RENEWAL_DETAILS"),
    DATE_FORMATTER("dd-MM-yyyy");

    String value;

    Commands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
