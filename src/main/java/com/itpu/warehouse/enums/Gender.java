package com.itpu.warehouse.enums;

public enum Gender {
    MALE,
    FEMALE,
    UNKNOWN;

    public static Gender fromString(String value) {
        if (value.equalsIgnoreCase("MALE")) {
            return MALE;
        } else if (value.equalsIgnoreCase("FEMALE")) {
            return FEMALE;
        } else {
            return UNKNOWN;
        }
    }
}
