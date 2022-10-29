package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.enums.UserType;
import com.spm.arogya.repository.CounselorRepository;
import com.spm.arogya.repository.PatientRepository;
import com.spm.arogya.service.ICounselorService;
import com.spm.arogya.service.ILoginService;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements ILoginService {

    private IPatientService iPatientService;
    private ICounselorService iCounselorService;
    private HashMap<UserType, UserLogin> hsmap = new HashMap<>();
    @Autowired
    public LoginServiceImpl(IPatientService iPatientService, ICounselorService iCounselorService){
        this.iPatientService=iPatientService;
        this.iCounselorService=iCounselorService;
        this.hsmap.put(UserType.PATIENT, (UserLogin) iPatientService);
        this.hsmap.put(UserType.CONSULTANT, (UserLogin) iCounselorService);
    }

    @Override
    public LoginResponse getLoginDetails(String email, String password, String userType) throws LoginException {
        return hsmap.get(UserType.valueOf(userType)).getLoginDetails(email, password);
    }
}
