package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.enums.UserType;
import com.spm.arogya.repository.PatientRepository;
import com.spm.arogya.service.ILoginService;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    private PatientRepository patientRepository;

    @Autowired
    public LoginServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;

    }

    @Override
    public LoginResponse getLoginDetails(String email, String password, String userType) throws LoginException {
        throw  new LoginException("");
    }
}
