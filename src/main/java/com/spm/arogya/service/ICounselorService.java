package com.spm.arogya.service;

import com.spm.arogya.dto.CounselorRegistrationRequestDto;
import com.spm.arogya.exception.CounselorRegistrationException;
import com.spm.arogya.model.Counselor;

/**
 * The interface Counselor service.
 */
public interface ICounselorService {

    /**
     * Save counselor counselor.
     *
     * @param counselorRegistrationRequestDto the counselor registration request dto
     * @return the counselor
     * @throws CounselorRegistrationException the counselor registration exception
     */
    Counselor saveCounselor(CounselorRegistrationRequestDto counselorRegistrationRequestDto) throws CounselorRegistrationException;

}
