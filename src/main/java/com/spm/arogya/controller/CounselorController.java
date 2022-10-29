package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.dto.CounselorRegistrationResponseDto;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.service.ICounselorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * The type Counselor controller.
 */
@RestController
@CrossOrigin
@RequestMapping(UriConstants.BASE_URL)
public class CounselorController {

    private final ICounselorService iCounselorService;

    /**
     * Instantiates a new  controller.
     *
     * @param iCounselorService the  service
     */
    @Autowired
    public CounselorController(ICounselorService iCounselorService){
        this.iCounselorService = iCounselorService;
    }

    /**
     * Register counselor response dto.
     *
     * @param counselorRegistrationRequestDto the counselor registration request dto
     * @return the response dto
     */
    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_COUNSELOR)
    public ResponseDto<CounselorRegistrationResponseDto> registerCounselor(@RequestBody CounselorRegistrationRequestDto counselorRegistrationRequestDto){
        Counselor counselor;
        try{
            counselor = iCounselorService.saveCounselor(counselorRegistrationRequestDto);
        } catch (CounselorRegistrationException e) {
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        catch (Exception e){
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
        return new ResponseDto<>(
                CounselorRegistrationResponseDto.builder()
                        .firstName(counselor.getFirstName())
                        .middleName(counselor.getMiddleName())
                        .lastName(counselor.getLastName())
                        .age(counselor.getAge())
                        .emailAddress(counselor.getEmailAddress())
                        .phoneNumber(counselor.getPhoneNumber())
                        .gender(counselor.getGender().getGenderDisplay())
                        .registrationNumber(counselor.getRegistrationNumber())
                        .build()
        );
    }

}
