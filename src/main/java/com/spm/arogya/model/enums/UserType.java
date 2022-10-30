package com.spm.arogya.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserType {
    PATIENT("patient"),
    COUNSELOR("counselor"),
    DOCTOR("doctor"),
    ADMIN("admin");

    private String userType;
}
