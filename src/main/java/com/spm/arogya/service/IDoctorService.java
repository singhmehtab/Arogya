package com.spm.arogya.service;

import com.spm.arogya.dto.DoctorRegistrationRequestDto;
import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.dto.Patient.PatientRegistrationRequestDto;
import com.spm.arogya.exception.DoctorRegistrationException;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.exception.PatientRegistrationException;
import com.spm.arogya.model.Doctor;
import com.spm.arogya.model.Patient;

import javax.print.Doc;

/**
 * The interface Patient service.
 */
public interface IDoctorService {

    /**
     * Save patient patient.
     *
     * @param patientRegistrationRequestDto the patient registration request dto
     * @return the patient
     * @throws PatientRegistrationException the patient registration exception
     */
    Doctor saveDoctor(DoctorRegistrationRequestDto doctorRegistrationRequestDto) throws DoctorRegistrationException;

    LoginResponse getLoginDetails(String email, String password) throws LoginException;
}
