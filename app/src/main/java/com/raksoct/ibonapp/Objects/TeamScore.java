package com.raksoct.ibonapp.Objects;

import java.io.Serializable;

/**
 * Created by Reiner on 8/12/2015.
 */
public class TeamScore implements Serializable
{
    int teamNo;
    int Score;

    public int getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(int teamNo) {
        this.teamNo = teamNo;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
