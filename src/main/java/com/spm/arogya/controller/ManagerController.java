package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.*;
import com.spm.arogya.exception.ManagerRegistrationException;
import com.spm.arogya.model.Manager;
import com.spm.arogya.service.IManagerService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping(UriConstants.BASE_URL)
public class ManagerController {

    private final IManagerService iManagerService;

    /**
     * Instantiates a new  controller.
     *
     * @param iManagerService the  service
     */
    @Autowired
    public ManagerController(IManagerService iManagerService){
        this.iManagerService = iManagerService;
    }

    /**
     * Register counselor response dto.
     *
     * @param managerRegistrationRequestDto the counselor registration request dto
     * @return the response dto
     */
    @RequestMapping(method = RequestMethod.POST, value = UriConstants.REGISTER_MANAGER)
    public ResponseDto<ManagerRegistrationResponseDto> registerCounselor(@RequestBody ManagerRegistrationRequestDto managerRegistrationRequestDto){
        Manager manager;
        try{
            manager = iManagerService.saveManager(managerRegistrationRequestDto);
        } catch (ManagerRegistrationException e) {
            return new ResponseDto<>(Collections.singletonList(e.getMessage()));
        }
        catch (Exception e){
            log.error("Error occurred ::", e );
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
        return new ResponseDto<>(
                ManagerRegistrationResponseDto.builder()
                        .id(manager.getId())
                        .firstName(manager.getFirstName())
                        .middleName(manager.getMiddleName())
                        .lastName(manager.getLastName())
                        .age(manager.getAge())
                        .emailAddress(manager.getEmailAddress())
                        .phoneNumber(manager.getPhoneNumber())
                        .gender(manager.getGender().getGenderDisplay())
                        .build()
        );
    }

    @RequestMapping(method=RequestMethod.GET, value = "report")
    public ResponseDto<ManagerReport> getReport(){
        try{
            ManagerReport managerReport=iManagerService.getManagerReport();
            return new ResponseDto<>(managerReport);
        }catch (Exception ex){
            log.error("Error occurred ::", ex );
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
    }
}
