package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointmentRequestDto {

    @JsonProperty("email_address")
    private String patient_email;

    @JsonProperty("assessment")
    private Questions questions;

}
