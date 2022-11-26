package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.Questions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAppointmentResponseDto {

    @JsonProperty("self_assessment")
    private boolean selfAssessment;

    @JsonProperty("details")
    private List<AppointmentDetails> appointmentDetails;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AppointmentDetails {

        @JsonProperty("appointment_id")
        private Integer appointmentId;

        @JsonProperty("appointment_start_time")
        private Date appointmentStartTime;

        @JsonProperty("appointment_end_time")
        private Date appointmentEndTime;

        @JsonProperty("question_answers")
        private Questions questions;

        @JsonProperty("counsellor_id")
        private String counsellorRegistrationNumber;

        @JsonProperty("doctor_id")
        private String doctorRegistrationNumber;

        @JsonProperty("patient")
        private Patient patient;

        @JsonProperty("self_assessment")
        private boolean selfAssessment;
    }

}
