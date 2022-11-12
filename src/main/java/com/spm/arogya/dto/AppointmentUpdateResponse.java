package com.spm.arogya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentUpdateResponse {
    private String message="Record modified";
}
