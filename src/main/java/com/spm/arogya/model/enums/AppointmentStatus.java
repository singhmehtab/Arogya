package com.spm.arogya.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public enum AppointmentStatus {
    //status 0 -> appointment born
    //status 1 -> rejected by counsellor
    //status 2 -> scheduled with counsellor
    //status 3 -> scheduled with doctor
    //status 4 -> accepted by doctor
    //status 5 -> rejected by doctor
    APPOINTMENT_BORN(0),
    REJECTED_BY_COUNSELLOR(1),
    SCHEDULED_WITH_COUNSELLOR(2),
    SCHEDULED_WITH_DOCTOR(3),
    ACCEPTED_BY_DOCTOR(4),
    REJECTED_BY_DOCTOR(5);

    private int status;


}
