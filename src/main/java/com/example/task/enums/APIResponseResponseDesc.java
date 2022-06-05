package com.example.task.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum APIResponseResponseDesc {

    SUCCESS("Success"),
    FAILED("Failed"),
    NO_DATA_FOUND("No data found"),
    MISSING_REQUIRED_FIELDS("Missing Required Fields"),
    INVALID_LENGTH("Invalid Length");

    private final String code;

    APIResponseResponseDesc(String code) {
        this.code = code;
    }

    public static APIResponseResponseDesc fromId(String id) {
        for (APIResponseResponseDesc at : APIResponseResponseDesc.values()) {
            if (at.getCode().equals(id)) {
                return at;
            }
        }
        return null;
    }
}
