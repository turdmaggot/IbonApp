package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.Objects.Category;

public class SinglePlayerEnd extends Activity
{

    TextView txtCategory;
    TextView txtScore;
    Button btnReplay;
    Button btnChooseCategory;
    Category chosenCategory;
    String strTotalPoints;
    int categoryID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_end);

        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtScore = (TextView) findViewById(R.id.txtScore);
        btnReplay = (Button) findViewById(R.id.btnEnd);
        btnChooseCategory = (Button) findViewById(R.id.btnChooseCategory);

        //get intents
        Bundle bundle = getIntent().getExtras();
        categoryID = bundle.getInt("categoryID");
        strTotalPoints =  bundle.getString("totalPoints");
        QuestionManager qm = new QuestionManager();
        chosenCategory = qm.getCategoryByID(categoryID);

        txtCategory.setText(chosenCategory.getTitle());
        txtScore.setText(strTotalPoints);

        btnChooseCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction("back");
            }
        });

        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction("replay");
            }
        });
    }


    private void doAction(String action)
    {
        if (action.equals("replay"))
        {
            Intent i = new Intent(this, SinglePlayerMode.class);
            i.putExtra("categoryID", categoryID);
            this.startActivity(i);
            finish();
        }
        else
        {
            Intent i = new Intent(this, SinglePlayerMain.class);
            this.startActivity(i);
            finish();
        }
    }


    @Override
    public void onBackPressed()
    {
        finish();
    }
}
