package com.spm.arogya.service;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.dto.ManagerRegistrationRequestDto;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.exception.ManagerRegistrationException;
import com.spm.arogya.model.Manager;

/**
 * The interface Patient service.
 */
public interface IManagerService {


    Manager saveManager(ManagerRegistrationRequestDto managerRegistrationRequestDto) throws ManagerRegistrationException;

    LoginResponse getLoginDetails(String email, String password) throws LoginException;
}
