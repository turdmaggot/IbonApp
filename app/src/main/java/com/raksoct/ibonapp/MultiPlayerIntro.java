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
import com.raksoct.ibonapp.Objects.Question;
import com.raksoct.ibonapp.Objects.TeamScore;

import java.util.ArrayList;
import java.util.List;

public class MultiPlayerIntro extends Activity {

    Button btnProceed;
    TextView txtTurn;
    TextView txtCategory;
    MultiPlayerSet set;
    Category chosenCategory;
    int noOfTeams;
    int teamToPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_intro);

        btnProceed = (Button) findViewById(R.id.btnProceed);
        txtTurn = (TextView) findViewById(R.id.txtTurn);
        txtCategory = (TextView) findViewById(R.id.txtCategory);

        QuestionManager qm = new QuestionManager();

        Bundle bundle  = getIntent().getExtras();
        chosenCategory = qm.getCategoryByID(bundle.getInt("categoryID"));

        txtCategory.setText(chosenCategory.getTitle());

        noOfTeams = bundle.getInt("teams");
        teamToPlay = bundle.getInt("teamToPlay");

        txtTurn.setText("Group " + Integer.toString(teamToPlay + 1) + ", handa na ba kayo maglaro?");


        //instantiate questions if first time, else just get from intent! also get resultlist;
        if (teamToPlay == 0)
        {
            List <Question> questions = QuestionManager.shuffleAndPrepareQuestionList(10, chosenCategory.getQuestions());
            List <TeamScore> teamScores = new ArrayList<>();
            set = new MultiPlayerSet();
            set.setQuestions(questions);
            set.setScores(teamScores);
        }
        else
        {
            set = (MultiPlayerSet) bundle.getSerializable("set");
        }
        btnProceed.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                loadQuiz();
            }
        });
    }

    private void loadQuiz()
    {
        Intent i = new Intent(this, MultiPlayerMode.class);
        Bundle bundle = new Bundle();
        bundle.putInt("categoryID", chosenCategory.getID());
        bundle.putInt("teams", noOfTeams);
        bundle.putInt("teamToPlay",teamToPlay);
        bundle.putSerializable("set", set);
        i.putExtras(bundle);
        this.startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}
