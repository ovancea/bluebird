package com.internship.bluebird.config;

public enum StatusEnum {
    NEW("New"),
    IN_PROGRESS("In progress"),
    IN_REVIEW("In review"),
    DONE("Done");

    private String value;

    StatusEnum(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
