package com.naukma.aspectj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class InterviewStatsAspectXMLBased {

    private int correctAnswers;
    private int incorrectAnswers;
    private int applicantErrors;

    public InterviewStatsAspectXMLBased() {
        int kek = 1;
        kek++;
    }


    public void reset() {
        correctAnswers = 0;
        incorrectAnswers = 0;
        applicantErrors = 0;
    }

    public String applicantAnswerLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        String question = (String)joinPoint.getArgs()[0];
        String answer = (String)joinPoint.proceed();
        System.out.println("(XML) Applicant answered " + answer + " for question " + question);
        return answer;
    }

    public void onApplicantAnswerException() {
        applicantErrors++;
    }

    public void onInterviewerCorrectnessCheck(Object retVal) {
        if((boolean)retVal) {
            correctAnswers++;
        } else {
            incorrectAnswers++;
        }
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public int getApplicantErrors() {
        return applicantErrors;
    }
}
