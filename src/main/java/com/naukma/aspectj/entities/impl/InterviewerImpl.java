package com.naukma.aspectj.entities.impl;

import com.naukma.aspectj.entities.Interviewer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InterviewerImpl implements Interviewer {

    private final Map<String, String> answersByQuestions;
    private Iterator<String> questionIterator;

    public InterviewerImpl() {
        Map<String, String> map = new HashMap<>();
        map.put("1+1", "2");
        map.put("2+2", "4");
        map.put("2*2", "4");
        answersByQuestions = Collections.unmodifiableMap(map);
        questionIterator = answersByQuestions.keySet().iterator();
    }

    @Override
    public String generateQuestion() {
        if(!questionIterator.hasNext()) {
            return null;
        }
        return questionIterator.next();
    }

    @Override
    public boolean checkAnswerCorrectness(String question, String answer) {
        return answersByQuestions.get(question) != null && answersByQuestions.get(question).equals(answer);
    }

    @Override
    public void reset() {
        questionIterator = answersByQuestions.keySet().iterator();
    }
}
