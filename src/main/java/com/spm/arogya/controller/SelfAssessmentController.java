package com.spm.arogya.controller;

import com.spm.arogya.constants.UriConstants;
import com.spm.arogya.dto.ResponseDto;
import com.spm.arogya.model.Questions;
import com.spm.arogya.service.IAppointmentService;
import com.spm.arogya.service.ISelfAssessmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(UriConstants.BASE_URL)
public class SelfAssessmentController {

    private final ISelfAssessmentService iSelfAssessmentService;

    @Autowired
    public SelfAssessmentController(ISelfAssessmentService iSelfAssessmentService){
        this.iSelfAssessmentService = iSelfAssessmentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = UriConstants.GET_QUESTIONS)
    public ResponseDto<Questions> getQuestionsList(){
        return new ResponseDto<>(iSelfAssessmentService.getQuestionsList());
    }

}
