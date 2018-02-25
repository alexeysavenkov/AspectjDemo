package com.naukma.aspectj.entities.impl;

import com.naukma.aspectj.entities.Applicant;
import com.naukma.aspectj.exceptions.SuperHardQuestionException;
import org.springframework.stereotype.Component;

@Component
public class ApplicantImpl implements Applicant {
    @Override
    public String tryAnswerQuestion(String question) throws SuperHardQuestionException {
        switch (question) {
            case "1+1":
                return "2";
            case "2+2":
                return "5";
            default:
                throw new SuperHardQuestionException();
        }
    }
}
