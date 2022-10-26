package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.PatientRegistrationRequestDto;
import com.spm.arogya.dto.PatientRegistrationResponseDto;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.exception.PatientRegistrationException;
import com.spm.arogya.model.Patient;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping(UriConstants.BASE_URL)
public class PatientController {

    private final IPatientService iPatientService;

    /**
     * Instantiates a new Patient controller.
     *
     * @param iPatientService the patient service
     */
    @Autowired
    public PatientController(IPatientService iPatientService){
        this.iPatientService = iPatientService;
    }

    /**
     * Register patient response dto.
     *
     * @param patientRegistrationRequestDto the patient registration request dto
     * @return the response dto
     */
    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_USER)
    public ResponseDto<PatientRegistrationResponseDto> registerPatient(@RequestBody PatientRegistrationRequestDto patientRegistrationRequestDto){
        Patient patient;
        try{
            patient = iPatientService.savePatient(patientRegistrationRequestDto);
        } catch (PatientRegistrationException e) {
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        catch (Exception e){
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
        return new ResponseDto<>(
                PatientRegistrationResponseDto.builder()
                        .firstName(patient.getFirstName())
                        .middleName(patient.getMiddleName())
                        .lastName(patient.getLastName())
                        .age(patient.getAge())
                        .emailAddress(patient.getEmailAddress())
                        .phoneNumber(patient.getPhoneNumber())
                        .gender(patient.getGender().getGenderDisplay())
                        .build()
        );
    }

}
