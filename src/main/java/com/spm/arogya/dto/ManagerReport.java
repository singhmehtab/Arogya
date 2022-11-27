package com.spm.arogya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManagerReport {
    @JsonProperty("self_assessment_filled_count")
    private int selfAssessmentFilled;
    @JsonProperty("patient_with_doctor_assigned")
    private int patientWithDoctorAssignedAssigned;
    @JsonProperty("users_count")
    private UsersCount usersCount;
}
