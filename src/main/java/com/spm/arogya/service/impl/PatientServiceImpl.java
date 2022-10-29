package com.spm.arogya.service.impl;

import com.spm.arogya.dto.PatientRegistrationRequestDto;
import com.spm.arogya.exception.PatientRegistrationException;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.PatientRepository;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type Patient service.
 */
@Service
public class PatientServiceImpl implements IPatientService {

    private PatientRepository patientRepository;

    /**
     * Instantiates a new Patient service.
     *
     * @param patientRepository the patient repository
     */
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient savePatient(PatientRegistrationRequestDto patientRegistrationRequestDto) throws PatientRegistrationException {

        if(Objects.isNull(patientRegistrationRequestDto.getAge())) throw new PatientRegistrationException("Age is Required");
        else if(Objects.isNull(patientRegistrationRequestDto.getGender())) throw new PatientRegistrationException("Gender is Required");
        else if(Objects.isNull(patientRegistrationRequestDto.getLastName())) throw new PatientRegistrationException("Last name is Required");
        else if (Objects.isNull(patientRegistrationRequestDto.getEmailAddress())) throw new PatientRegistrationException("Email Address is required");
        else if(Objects.isNull(patientRegistrationRequestDto.getPassword())) throw new PatientRegistrationException("Password is required");

        if(Objects.nonNull(patientRepository.findFirstByAgeAndPhoneNumberAndGender(patientRegistrationRequestDto.getAge(), patientRegistrationRequestDto.getPhoneNumber(), Gender.getGender(patientRegistrationRequestDto.getGender())))){
            throw new PatientRegistrationException("Patient with same age, phone number and gender already exists");
        }
        if(Objects.nonNull(patientRepository.findFirstByEmailAddress(patientRegistrationRequestDto.getEmailAddress()))){
            throw new PatientRegistrationException("Patient with same email address already exists");
        }

        Patient patient = Patient.builder()
                .firstName(patientRegistrationRequestDto.getFirstName())
                .middleName(patientRegistrationRequestDto.getMiddleName())
                .lastName(patientRegistrationRequestDto.getLastName())
                .age(patientRegistrationRequestDto.getAge())
                .emailAddress(patientRegistrationRequestDto.getEmailAddress())
                .gender(Gender.getGender(patientRegistrationRequestDto.getGender()))
                .phoneNumber(patientRegistrationRequestDto.getPhoneNumber())
                .password(patientRegistrationRequestDto.getPassword())
                .build();
        patientRepository.save(patient);
        return patient;
    }
}
