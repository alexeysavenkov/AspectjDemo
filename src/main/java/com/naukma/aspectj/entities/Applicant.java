package com.naukma.aspectj.entities;

import com.naukma.aspectj.exceptions.SuperHardQuestionException;

public interface Applicant {
    String tryAnswerQuestion(String question) throws SuperHardQuestionException;
}
