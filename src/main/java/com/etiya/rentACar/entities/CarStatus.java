package com.etiya.rentacar.entities;

public enum CarStatus {
    AVAILABLE(0),
    UNDER_MAINTENANCE(1),
    RENTED(2);

    private final int value;

    CarStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CarStatus fromValue(int value) {
        for (CarStatus status : CarStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid CarStatus value: " + value);
    }
}
