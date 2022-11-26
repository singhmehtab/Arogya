package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentUpdateRequest {

    @JsonProperty("appointment_id")
    private int appointmentId;
    @JsonProperty("status")
    private Integer status;
    @JsonProperty("counselor_id")
    private String counsellor_id;
    @JsonProperty("doctor_id")
    private String doctorId;
}
