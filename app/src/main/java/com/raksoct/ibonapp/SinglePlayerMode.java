package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
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
import com.raksoct.ibonapp.Objects.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SinglePlayerMode extends Activity {

    QuestionManager qm;
    Category chosenCategory;
    TextView txtQuestion;
    TextView txtCategory;
    TextView txtPoints;
    ListView lvChoices;
    Question question;
    int currentQuestionNumber;
    int totalPoints = 0;

    List<Question> finalizedQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_mode);

        Bundle bundle = getIntent().getExtras();
        int categoryID = bundle.getInt("categoryID");
        qm = new QuestionManager();
        chosenCategory = qm.getCategoryByID(categoryID);

        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtPoints = (TextView) findViewById(R.id.txtPoints);
        lvChoices = (ListView) findViewById(R.id.lvChoices);

        txtCategory.setText(chosenCategory.getTitle());

        finalizedQuestions = qm.shuffleAndPrepareQuestionList(10, chosenCategory.getQuestions());

        displayQuestion(0);

        lvChoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                checkAnswer(question, question.getChoices().get(i));

                if (currentQuestionNumber < finalizedQuestions.size())
                {
                    displayQuestion(currentQuestionNumber);
                }
                else
                {
                    //Toast.makeText(getApplicationContext(), "Questions done!", Toast.LENGTH_LONG).show();
                    concludeGame();
                }
            }
        });

    }


    private void concludeGame()
    {
        Intent i = new Intent(this, SinglePlayerEnd.class);
        i.putExtra("totalPoints", Integer.toString(totalPoints) + "/" + Integer.toString(finalizedQuestions.size()));
        i.putExtra("categoryID", chosenCategory.getID());
        this.startActivity(i);
        finish();
    }

    private void displayQuestion(int id)
    {
        txtPoints.setText("Puntos: " + Integer.toString(totalPoints));
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
            Toast.makeText(this, "Tama ang iyong sagot!", Toast.LENGTH_LONG).show();
            totalPoints ++;
        }
        else
        {
            Toast.makeText(this, "Mali ka. Ang tamang sagot ay " + correctAnswer.getChoice(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}
