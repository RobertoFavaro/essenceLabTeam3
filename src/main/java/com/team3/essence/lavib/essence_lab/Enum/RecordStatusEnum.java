package com.team3.essence.lavib.essence_lab.Enum;

public enum RecordStatusEnum {
    A("Attivo"),
    I("Inattivo");

    private String description;

    RecordStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}