package com.raksoct.ibonapp.Objects;

import android.text.SpannableStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Reiner on 8/6/2015.
 */
public class Question implements Serializable
{
    private String Question;
    private SpannableStringBuilder QuestionBold;
    private List<Choice> Choices;


    public SpannableStringBuilder getQuestionBold() {
        return QuestionBold;
    }

    public void setQuestionBold(SpannableStringBuilder questionBold) {
        QuestionBold = questionBold;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public List<Choice> getChoices() {
        return Choices;
    }

    public void setChoices(List<Choice> choices) {
        Choices = choices;
    }


    public Question(String Question)
    {
        this.Question = Question;
    }

    public Question(SpannableStringBuilder QuestionBold)
    {
        this.QuestionBold = QuestionBold;
    }
}
