package com.spm.arogya.dto.Counsellor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spm.arogya.dto.GetAppointmentResponseDto;
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
    private GetAppointmentResponseDto pendingAppointments;

    @JsonProperty("scheduled_appointments")
    private GetAppointmentResponseDto  scheduledAppointments;

    @JsonProperty("canceled_appointments")
    private GetAppointmentResponseDto cancelledAppointments;
}
