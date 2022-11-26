package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.dto.Patient.PatientRegistrationRequestDto;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.exception.PatientRegistrationException;
import com.spm.arogya.model.Appointment;
import com.spm.arogya.model.Patient;
import com.spm.arogya.model.enums.Gender;
import com.spm.arogya.repository.AppointmentRepository;
import com.spm.arogya.repository.PatientRepository;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * The type Patient service.
 */
@Service
public class PatientServiceImpl extends  UserLogin implements IPatientService {

    private PatientRepository patientRepository;

    private AppointmentRepository appointmentRepository;

    /**
     * Instantiates a new Patient service.
     *
     * @param patientRepository the patient repository
     */
    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, AppointmentRepository appointmentRepository){
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Patient savePatient(PatientRegistrationRequestDto patientRegistrationRequestDto) throws PatientRegistrationException {

        if (Objects.isNull(patientRegistrationRequestDto.getEmailAddress())) throw new PatientRegistrationException("Email Address is required");
        else if(Objects.isNull(patientRegistrationRequestDto.getPassword())) throw new PatientRegistrationException("Password is required");

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

    public  LoginResponse getLoginDetails(String email, String password) throws LoginException {
        LoginResponse loginResponse=new LoginResponse();
        Patient patient=patientRepository.findFirstByEmailAddressAndPassword(email, password);
        if(patient==null){
            loginResponse.setLogged(false);
            return loginResponse;
        }
        loginResponse.setId(patient.getId());
        loginResponse.setLogged(true);
        loginResponse.setAge(patient.getAge());
        loginResponse.setGender(patient.getGender());
        loginResponse.setFirstName(patient.getFirstName());
        loginResponse.setMiddleName(patient.getMiddleName());
        loginResponse.setLastName(patient.getLastName());
        loginResponse.setPhoneNumber(patient.getPhoneNumber());
        loginResponse.setEmailAddress(patient.getEmailAddress());
        return loginResponse;
    }

    @Override
    public Patient findByEmailId(String emailId) {
        return patientRepository.findFirstByEmailAddress(emailId);
    }

    @Override
    public List<Patient> getPatientsList() {
        return patientRepository.findAll();
    }

    @Override
    @Transactional
    public void deletePatient(String emailAddress) {
        Patient patient = findByEmailId(emailAddress);
        appointmentRepository.deleteAppointmentByPatient(patient);
        patientRepository.deleteAllByEmailAddress(emailAddress);
    }


}
