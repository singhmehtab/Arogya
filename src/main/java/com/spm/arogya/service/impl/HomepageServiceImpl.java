package com.spm.arogya.service.impl;

import com.spm.arogya.dto.UsersCount;
import com.spm.arogya.service.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements IHomepageService {
    private IPatientService iPatientService;
    private ICounselorService iCounselorService;
    private IDoctorService iDoctorService;
    @Autowired
    public HomepageServiceImpl(IPatientService iPatientService,ICounselorService iCounselorService,IDoctorService iDoctorService){
        this.iDoctorService=iDoctorService;
        this.iCounselorService=iCounselorService;
        this.iPatientService=iPatientService;
    }
    @Override
    public UsersCount getUserCount() {
        int counsellorCount=iCounselorService.getCounselorsList().size();
        int patientCount=iPatientService.getPatientsList().size();
        int doctorCount=iDoctorService.getDoctorsList().size();
        UsersCount usersCount=UsersCount.builder()
                .counsellorCount(counsellorCount)
                .doctorCount(doctorCount)
                .patientCount(patientCount)
                .build();
        return usersCount;
    }
}
