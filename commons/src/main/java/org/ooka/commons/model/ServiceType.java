package org.ooka.commons.model;

import lombok.Getter;

@Getter
public enum ServiceType {

    AUXILIARY_SYSTEM("0"),
    CONTROL_SYSTEM("1"),
    ENGINE_SYSTEM("2"),
    MOUNTING_SYSTEM("3"),
    POWER_TRANSMISSION("4");

    private final String uuid;

    ServiceType(String uuid) {
        this.uuid = uuid;
    }

}
