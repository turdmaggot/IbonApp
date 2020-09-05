package com.raksoct.ibonapp.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Reiner on 8/12/2015.
 */
public class MultiPlayerSet implements Serializable
{
    private List<Question> questions;
    private List<TeamScore> scores;

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setScores(List<TeamScore> scores) {
        this.scores = scores;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<TeamScore> getScores() {
        return scores;
    }
}
