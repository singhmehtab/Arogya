package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.Counsellor.CounselorHomepageResponseDto;
import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.dto.CounselorRegistrationResponseDto;
import com.spm.arogya.dto.GetAppointmentResponseDto;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.exception.CounselorHomepageException;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.model.Counselor;
import com.spm.arogya.model.Doctor;
import com.spm.arogya.service.ICounselorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * The type Counselor controller.
 */
@RestController
@CrossOrigin
@Slf4j
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
            log.error("Error occurred ::", e );
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

    @RequestMapping(method = RequestMethod.GET, value = UriConstants.HOMEPAGE_COUNSELOR)
    public ResponseDto<CounselorHomepageResponseDto> homepageCounselor(@RequestParam(value = "counsellor_id", required = false) String counsellorId){
        CounselorHomepageResponseDto counselorHomepageResponseDto;
        try{
            counselorHomepageResponseDto = iCounselorService.getHomePage(counsellorId);
            return new ResponseDto<>(counselorHomepageResponseDto);
        } catch (CounselorHomepageException e) {
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        catch (Exception e){
            log.error("Error occurred ::", e );
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_COUNSELOR_LIST)
    public ResponseDto<List<Counselor>> getCounselor(){

        List<Counselor> list;
        try{
            list = iCounselorService.getCounselorsList();
        }
        catch (Exception e){
            log.error("Error occurred :: " , e);
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
        return new ResponseDto<>(list);
    }

}
