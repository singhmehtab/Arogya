package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentUpdateRequest {

    @JsonProperty("appointment_id")
    private int appointmentId;
    @JsonProperty("status")
    private int status;
    @JsonProperty("counsellor_id")
    private String counsellor_id;
    @JsonProperty("doctor_id")
    private String doctorId;
}
