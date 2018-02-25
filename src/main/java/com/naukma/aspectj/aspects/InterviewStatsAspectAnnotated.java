package com.naukma.aspectj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect()
public class InterviewStatsAspectAnnotated {

    private int correctAnswers;
    private int incorrectAnswers;
    private int applicantErrors;

    @Before("execution(void com.naukma.aspectj.entities.Interview.runInterview(..))")
    public void reset() {
        correctAnswers = 0;
        incorrectAnswers = 0;
        applicantErrors = 0;
    }

    @Around("execution(String com.naukma.aspectj.entities.Applicant.tryAnswerQuestion(String))")
    public String applicantAnswerLogger(ProceedingJoinPoint joinPoint) throws Throwable {
        String question = (String)joinPoint.getArgs()[0];
        String answer = (String)joinPoint.proceed();
        System.out.println("Applicant answered " + answer + " for question " + question);
        return answer;
    }

    @AfterThrowing("execution(String com.naukma.aspectj.entities.Applicant.tryAnswerQuestion(String))")
    public void onApplicantAnswerException() {
        applicantErrors++;
    }

    @AfterReturning(pointcut = "execution(boolean com.naukma.aspectj.entities.Interviewer.checkAnswerCorrectness(..))",
            returning = "retVal")
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
