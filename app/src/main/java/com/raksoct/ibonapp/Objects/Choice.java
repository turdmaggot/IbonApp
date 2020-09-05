package com.raksoct.ibonapp.Objects;

import java.io.Serializable;

/**
 * Created by Reiner on 8/6/2015.
 */
public class Choice implements Serializable
{
    private String Choice;
    private Boolean IsCorrect;

    public String getChoice() {
        return Choice;
    }

    public void setChoice(String choice) {
        Choice = choice;
    }

    public Boolean getIsCorrect() {
        return IsCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        IsCorrect = isCorrect;
    }

    public Choice(String Choice, Boolean IsCorrect)
    {
        this.Choice = Choice;
        this.IsCorrect = IsCorrect;
    }

}
