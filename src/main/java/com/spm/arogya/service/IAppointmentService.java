package com.spm.arogya.service;

import com.spm.arogya.dto.AppointmentRequestDto;
import com.spm.arogya.dto.GetAppointmentResponseDto;
import com.spm.arogya.exception.AppointmentRegistrationException;
import com.spm.arogya.model.Appointment;

import java.util.List;

/**
 * The interface Patient service.
 */
public interface IAppointmentService {

    Appointment saveAppointment(AppointmentRequestDto appointmentRegistrationRequestDto) throws AppointmentRegistrationException;

    GetAppointmentResponseDto getAppointments(String emailAddress) throws AppointmentRegistrationException;

}
