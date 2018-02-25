package com.naukma.aspectj.entities;

public interface Interviewer {
    String generateQuestion();
    boolean checkAnswerCorrectness(String question, String answer);
    void reset();
}
