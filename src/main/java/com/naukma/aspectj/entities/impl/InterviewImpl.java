package com.naukma.aspectj.entities.impl;

import com.naukma.aspectj.entities.Applicant;
import com.naukma.aspectj.entities.Interview;
import com.naukma.aspectj.entities.Interviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="annotatedInterview")
public class InterviewImpl implements Interview {

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    @Autowired
    private Applicant applicant;

    @Autowired
    private Interviewer interviewer;

    @Override
    public void runInterview() {
        String question;
        while((question = interviewer.generateQuestion()) != null) {
            try {
                String answer = applicant.tryAnswerQuestion(question);
                interviewer.checkAnswerCorrectness(question, answer);
            } catch (Exception e) {
                // Ignore any exceptions
            }
        }

        // Reset state of interviewer
        interviewer.reset();

        // Do not return or save any result
        // It will be intercepted by InterviewStatsAspect
    }
}
