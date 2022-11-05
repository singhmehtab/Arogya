package com.spm.arogya.service.impl;

import com.spm.arogya.model.Questions;
import com.spm.arogya.service.ISelfAssessmentService;
import org.springframework.stereotype.Service;

@Service
public class SelfAssessmentServiceImpl implements ISelfAssessmentService {

    @Override
    public Questions getQuestionsList() {
        return Questions.getListOfQuestions();
    }


}
