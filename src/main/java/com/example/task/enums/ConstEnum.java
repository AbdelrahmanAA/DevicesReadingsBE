package com.example.task.enums;

import lombok.Getter;

@Getter
public enum ConstEnum {

    DEVICE_ID_LENGTH(8),
    TEMPERATURE_LENGTH(2);

    private final int value;

    ConstEnum(int value) {
        this.value = value;
    }

    public static ConstEnum fromId(int id) {
        for (ConstEnum at : ConstEnum.values()) {
            if (at.getValue() == id) {
                return at;
            }
        }
        return null;
    }
}
