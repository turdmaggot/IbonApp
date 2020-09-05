package com.raksoct.ibonapp.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Reiner on 8/6/2015.
 */
public class Category implements Serializable
{
    private int ID;
    private String Title;
    private List<Question> Questions;
    private boolean HasQuestions;

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String title)
    {
        Title = title;
    }

    public List<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(List<Question> questions) {
        Questions = questions;
    }

    public boolean isHasQuestions() {
        return HasQuestions;
    }

    public void setHasQuestions(boolean hasQuestions) {
        HasQuestions = hasQuestions;
    }

}
