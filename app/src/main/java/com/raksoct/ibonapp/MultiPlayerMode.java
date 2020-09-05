package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.ListviewAdapters.lvChoicesSingleAdapter;
import com.raksoct.ibonapp.Objects.Category;
import com.raksoct.ibonapp.Objects.Choice;
import com.raksoct.ibonapp.Objects.MultiPlayerSet;
import com.raksoct.ibonapp.Objects.Question;
import com.raksoct.ibonapp.Objects.TeamScore;

import java.util.List;

public class MultiPlayerMode extends Activity
{
    QuestionManager qm;
    Category chosenCategory;
    TextView txtQuestion;
    TextView txtCategory;
    ListView lvChoices;
    Question question;
    int numberOfQuestions;
    int currentQuestionNumber;
    int totalPoints = 0;
    List<Question> finalizedQuestions;

    int noOfTeams;
    int teamToPlay;
    MultiPlayerSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_mode);

        //get from intents...
        Bundle bundle  = getIntent().getExtras();
        set = (MultiPlayerSet) bundle.getSerializable("set");
        int categoryID = bundle.getInt("categoryID");
        noOfTeams = bundle.getInt("teams");
        teamToPlay = bundle.getInt("teamToPlay");

        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        lvChoices = (ListView) findViewById(R.id.lvChoices);

        qm = new QuestionManager();
        chosenCategory = qm.getCategoryByID(categoryID);

        txtCategory.setText(chosenCategory.getTitle());

        finalizedQuestions = set.getQuestions();

        displayQuestion(0);

        lvChoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                checkAnswer(question, question.getChoices().get(i));

                if (currentQuestionNumber < finalizedQuestions.size()) {
                    displayQuestion(currentQuestionNumber);
                }
                else
                {
                    if(teamToPlay == (noOfTeams - 1)) {
                        concludeGame();
                    }
                    else
                    {
                        int nextTeam = teamToPlay + 1;
                        passToNextTeam();
                    }
                }
            }
        });

    }

    private void displayQuestion(int id)
    {
        question = finalizedQuestions.get(id);

        if (chosenCategory.getID() != 10)
        {
            txtQuestion.setText(Integer.toString(id + 1) + ". " + question.getQuestion());
        }
        else
        {
            txtQuestion.setText(Html.fromHtml(Integer.toString(id + 1) + ". " + question.getQuestion()));
        }

        lvChoicesSingleAdapter lcsa = new lvChoicesSingleAdapter(this, question.getChoices());
        lvChoices.setAdapter(lcsa);

        currentQuestionNumber ++;
    }

    private void checkAnswer(Question question, Choice choice)
    {
        Choice correctAnswer = qm.getCorrectAnswer(question);
        if (choice.equals(correctAnswer))
        {
            //Toast.makeText(this, "Tama ang iyong sagot!", Toast.LENGTH_LONG).show();
            totalPoints ++;
        }
        else
        {
            //Toast.makeText(this, "Mali ka. Ang tamang sagot ay " + correctAnswer.getChoice(), Toast.LENGTH_LONG).show();
        }
    }

    private void concludeGame()
    {
        //Toast.makeText(getApplicationContext(), "Questions done!", Toast.LENGTH_LONG).show();
        MultiPlayerSet updatedSet = new MultiPlayerSet();
        updatedSet.setQuestions(set.getQuestions());
        List<TeamScore> scores = set.getScores();

        TeamScore thisScore = new TeamScore();
        thisScore.setScore(totalPoints);
        thisScore.setTeamNo(teamToPlay);

        scores.add(thisScore);
        updatedSet.setScores(scores);

        Intent i = new Intent(this, MultiPlayerEnd.class);
        i.putExtra("categoryID", chosenCategory.getID());
        i.putExtra("set", updatedSet);
        //i.putExtra("finalScoreSet", );
        //i.putExtra("categoryID", chosenCategory.getID());
        this.startActivity(i);
        finish();
    }

    private void passToNextTeam()
    {
        Intent i = new Intent(this, MultiPlayerIntro.class);
        i.putExtra("categoryID", chosenCategory.getID());
        i.putExtra("teams", noOfTeams);
        i.putExtra("teamToPlay", teamToPlay + 1);

        MultiPlayerSet updatedSet = new MultiPlayerSet();
        updatedSet.setQuestions(set.getQuestions());
        List<TeamScore> scores = set.getScores();

        TeamScore thisScore = new TeamScore();
        thisScore.setScore(totalPoints);
        thisScore.setTeamNo(teamToPlay);

        scores.add(thisScore);
        updatedSet.setScores(scores);
        i.putExtra("set", updatedSet);

        this.startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }



}
