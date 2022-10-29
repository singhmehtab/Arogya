package com.spm.arogya.service;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.LoginException;

public interface ILoginService {
    LoginResponse getLoginDetails(String email, String password, String userType) throws LoginException;

}
