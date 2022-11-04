package com.spm.arogya.service.impl;

import com.spm.arogya.dto.LoginResponse;
import com.spm.arogya.exception.LoginException;
import com.spm.arogya.model.enums.UserType;
import com.spm.arogya.service.ICounselorService;
import com.spm.arogya.service.IDoctorService;
import com.spm.arogya.service.ILoginService;
import com.spm.arogya.service.IManagerService;
import com.spm.arogya.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LoginServiceImpl implements ILoginService {

    private IPatientService iPatientService;
    private ICounselorService iCounselorService;
    private IManagerService iManagerService;
    private IDoctorService iDoctorService;
    private HashMap<UserType, UserLogin> hsmap = new HashMap<>();
    @Autowired
    public LoginServiceImpl(IPatientService iPatientService, ICounselorService iCounselorService, IManagerService iManagerService, IDoctorService iDoctorService){
        this.iPatientService=iPatientService;
        this.iCounselorService=iCounselorService;
        this.iManagerService = iManagerService;
        this.iDoctorService = iDoctorService;
        this.hsmap.put(UserType.PATIENT, (UserLogin) iPatientService);
        this.hsmap.put(UserType.COUNSELOR, (UserLogin) iCounselorService);
        this.hsmap.put(UserType.MANAGER, (UserLogin) iManagerService);
        this.hsmap.put(UserType.DOCTOR, (UserLogin) iDoctorService);
    }

    @Override
    public LoginResponse getLoginDetails(String email, String password, String userType) throws LoginException {
        return hsmap.get(UserType.getUserType(userType)).getLoginDetails(email, password);
    }
}
