package com.naukma.aspectj.controllers;

import com.naukma.aspectj.aspects.InterviewStatsAspect;
import com.naukma.aspectj.entities.Interview;
import org.aspectj.lang.Aspects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class InterviewController {

    @Autowired
    Interview interview;

    InterviewStatsAspect interviewStats;


    @RequestMapping("/run-interview")
    public String runInterview() {
       if(interviewStats == null) {
           interviewStats = Aspects.aspectOf(InterviewStatsAspect.class);
       }

       interview.runInterview();

       return String.format("Correct answers: %s <br> Incorrect answers: %s <br> Applicant errors: %s",
               interviewStats.getCorrectAnswers(),
               interviewStats.getIncorrectAnswers(),
               interviewStats.getApplicantErrors()
       );
    }


}