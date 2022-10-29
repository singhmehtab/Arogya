package com.spm.arogya.service;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.dto.Patient.PatientRegistrationRequestDto;
import com.spm.arogya.exception.PatientRegistrationException;
import com.spm.arogya.model.Patient;

/**
 * The interface Patient service.
 */
public interface IPatientService {

    /**
     * Save patient patient.
     *
     * @param patientRegistrationRequestDto the patient registration request dto
     * @return the patient
     * @throws PatientRegistrationException the patient registration exception
     */
    Patient savePatient(PatientRegistrationRequestDto patientRegistrationRequestDto) throws PatientRegistrationException;

    LoginResponse getPatientLoginDetails(String email, String password);
}
