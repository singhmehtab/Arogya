package com.spm.arogya.controller;

import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.dto.UsersCount;
import com.spm.arogya.service.IHomepageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@CrossOrigin
@RequestMapping("/homepage")
@Slf4j
public class HomepageController {
    @Autowired
    IHomepageService iHomepageService;
    @RequestMapping(method=RequestMethod.GET, value = "/count")
    public ResponseDto<UsersCount> getUsersCount(){
        try{
            UsersCount usersCount=iHomepageService.getUserCount();
            return new ResponseDto<>(usersCount);
        }catch (Exception ex){
            log.error("Error occurred ::", ex );
            return new ResponseDto<>(Collections.singletonList("Some Error Occurred"));
        }
    }
}
