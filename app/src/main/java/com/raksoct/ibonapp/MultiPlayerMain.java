package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.ListviewAdapters.lvCategoriesSingleAdapter;
import com.raksoct.ibonapp.Objects.Category;

import java.util.List;

public class MultiPlayerMain extends Activity
{

    ListView lvCategories;
    RadioGroup radioGroupChoice;
    int multiplayerMode = 2; //default

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player_main);

        lvCategories = (ListView) findViewById(R.id.lvCategories);
        radioGroupChoice = (RadioGroup) findViewById(R.id.radioGroupChoice);

        QuestionManager qm = new QuestionManager();
        final List<Category> categoryList = qm.getCategories();

        lvCategoriesSingleAdapter adapter = new lvCategoriesSingleAdapter(MultiPlayerMain.this, categoryList);
        lvCategories.setAdapter(adapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loadQuiz(categoryList.get(i));
            }
        });


        radioGroupChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch(i){
                    case R.id.twoPlayer:
                        multiplayerMode = 2;
                        break;

                    case R.id.threePlayer:
                        multiplayerMode = 3;
                        break;

                    case R.id.fourPlayer:
                        multiplayerMode = 4;
                        break;
                }
            }
        });

    }


    private void loadQuiz(Category category)
    {
        //String strMsg = "You have chosen " + Integer.toString(multiplayerMode) + " players group with the category " + category.getTitle() + ".";
        //Toast.makeText(this, strMsg, Toast.LENGTH_LONG).show();

        if (category.isHasQuestions())
        {

            Intent i = new Intent(this, MultiPlayerIntro.class);
            i.putExtra("categoryID", category.getID());
            i.putExtra("teams", multiplayerMode);
            i.putExtra("teamToPlay", 0); //start with team zero

            this.startActivity(i);
            finish();
        }
        else
        {
            Toast.makeText(this, "Wala pang mga tanong sa kategoryang ito.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed()
    {
        finish();
    }

}
