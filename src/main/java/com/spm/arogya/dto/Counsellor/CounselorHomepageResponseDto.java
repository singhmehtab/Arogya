package com.spm.arogya.dto.Counsellor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.model.Appointment;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CounselorHomepageResponseDto {
    @JsonProperty("pending_appointments")
    private List<Appointment> pendingAppointments;

    @JsonProperty("scheduled_appointments")
    private List<Appointment>  scheduledAppointments;

    @JsonProperty("canceled_appointments")
    private List<Appointment> cancelledAppointments;
}
