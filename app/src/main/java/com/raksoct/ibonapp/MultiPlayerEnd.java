package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.Objects.Category;
import com.raksoct.ibonapp.Objects.MultiPlayerSet;
import com.raksoct.ibonapp.Objects.TeamScore;

import java.util.List;

public class MultiPlayerEnd extends Activity {

    TextView txtCategory;
    TextView txtScore;
    Button btnEnd;
    Category chosenCategory;
    String strTotalPoints = "";
    int categoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_end);

        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        //get intents
        /*
        Bundle bundle = getIntent().getExtras();
        categoryID = bundle.getInt("categoryID");
        strTotalPoints =  bundle.getString("totalPoints");
        QuestionManager qm = new QuestionManager();
        chosenCategory = qm.getCategoryByID(categoryID);
        */

        Bundle bundle = getIntent().getExtras();

        int CategoryID = bundle.getInt("categoryID");
        MultiPlayerSet mps = (MultiPlayerSet) bundle.getSerializable("set");
        QuestionManager qm = new QuestionManager();
        chosenCategory = qm.getCategoryByID(CategoryID);
        List<TeamScore> scores = mps.getScores();

        for (TeamScore score : scores)
        {
            strTotalPoints += "Group " + Integer.toString(score.getTeamNo() + 1) + ": " + Integer.toString(score.getScore()) + " pts. \n";
        }


        txtCategory.setText(chosenCategory.getTitle());
        txtScore.setText(strTotalPoints);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction();
            }
        });

    }


    private void doAction()
    {
        //Intent i = new Intent(this, MainActivity.class);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }



}
