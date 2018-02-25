package com.naukma.aspectj.controllers;

import com.naukma.aspectj.aspects.InterviewStatsAspectAnnotated;
import com.naukma.aspectj.aspects.InterviewStatsAspectXMLBased;
import com.naukma.aspectj.entities.Interview;
import org.aspectj.lang.Aspects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class InterviewController {

    @Autowired
    @Qualifier("annotatedInterview")
    Interview annotatedInterview;

    Interview xmlBasedInterview;

    InterviewStatsAspectAnnotated interviewStatsAnnotated;
    InterviewStatsAspectXMLBased interviewStatsXMLBased;


    @RequestMapping("/run-interview")
    public String runInterview() {
       if(interviewStatsAnnotated == null) {
           interviewStatsAnnotated = Aspects.aspectOf(InterviewStatsAspectAnnotated.class);
       }

       if(xmlBasedInterview == null) {
            xmlBasedInterview = (Interview)getContext().getBean("interview");
            interviewStatsXMLBased = (InterviewStatsAspectXMLBased)getContext().getBean("interview-stats");
       }

       annotatedInterview.runInterview();
       xmlBasedInterview.runInterview();

       return "<h1>Annotated aspect results:</h1>" +
           String.format("Correct answers: %s <br> Incorrect answers: %s <br> Applicant errors: %s<br><br><br>",
               interviewStatsAnnotated.getCorrectAnswers(),
               interviewStatsAnnotated.getIncorrectAnswers(),
               interviewStatsAnnotated.getApplicantErrors()
           ) + "<h1>XML based aspect results:</h1>" +
           String.format("Correct answers: %s <br> Incorrect answers: %s <br> Applicant errors: %s",
               interviewStatsXMLBased.getCorrectAnswers(),
               interviewStatsXMLBased.getIncorrectAnswers(),
               interviewStatsXMLBased.getApplicantErrors()
           );
    }

    private ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("app-config.xml");
    }

}