package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class UsersCount {
    @JsonProperty("doctor_count")
    private int doctorCount;
    @JsonProperty("patient_count")
    private int patientCount;
    @JsonProperty("counsellor_count")
    private int counsellorCount;
}
