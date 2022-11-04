package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.DoctorRegistrationRequestDto;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.exception.DoctorRegistrationException;
import com.spm.arogya.model.Doctor;
import com.spm.arogya.service.IDoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * The type Patient controller.
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping(UriConstants.BASE_URL)
public class DoctorController {

    private final IDoctorService iDoctorService;

    /**
     * Instantiates a new Patient controller.
     *
     * @param iDoctorService the patient service
     */
    @Autowired
    public DoctorController(IDoctorService iDoctorService){
        this.iDoctorService = iDoctorService;
    }

    /**
     * Register patient response dto.
     *
     * @param doctorRegistrationRequestDto the patient registration request dto
     * @return the response dto
     */
    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_DOCTOR)
    public ResponseDto<DoctorRegistrationRequestDto> registerPatient(@RequestBody DoctorRegistrationRequestDto doctorRegistrationRequestDto){
        Doctor doctor;
        try{
            doctor = iDoctorService.saveDoctor(doctorRegistrationRequestDto);
        } catch (DoctorRegistrationException e) {
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        catch (Exception e){
            log.error("Error occurred :: " , e);
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
        return new ResponseDto<>(
                DoctorRegistrationRequestDto.builder()
                        .firstName(doctor.getFirstName())
                        .middleName(doctor.getMiddleName())
                        .lastName(doctor.getLastName())
                        .age(doctor.getAge())
                        .emailAddress(doctor.getEmailAddress())
                        .phoneNumber(doctor.getPhoneNumber())
                        .gender(doctor.getGender().getGenderDisplay())
                        .build()
        );
    }

}
