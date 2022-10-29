package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.LoginException;

public abstract class UserLogin {
    public abstract LoginResponse getLoginDetails(String email, String password) throws LoginException;

}
