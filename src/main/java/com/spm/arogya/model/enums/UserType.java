package com.spm.arogya.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {
    PATIENT("PATIENT"),
    CONSULTANT("CONSULTANT"),
    DOCTOR("DOCTOR"),
    ADMIN("ADMIN");

    private String userType;
}
