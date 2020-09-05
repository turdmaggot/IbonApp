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
import android.widget.Toast;

import com.raksoct.ibonapp.Helpers.QuestionManager;
import com.raksoct.ibonapp.ListviewAdapters.lvCategoriesSingleAdapter;
import com.raksoct.ibonapp.Objects.Category;

import java.util.List;

public class SinglePlayerMain extends Activity {

    ListView lvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player_main);

        lvCategories = (ListView) findViewById(R.id.lvCategories);

        QuestionManager qm = new QuestionManager();
        final List<Category> categoryList = qm.getCategories();

        lvCategoriesSingleAdapter adapter = new lvCategoriesSingleAdapter(SinglePlayerMain.this, categoryList);
        lvCategories.setAdapter(adapter);

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                loadQuiz(categoryList.get(i));
            }
        });
    }

    private void loadQuiz(Category category)
    {
        if (category.isHasQuestions())
        {
            Intent i = new Intent(this, SinglePlayerMode.class);
            i.putExtra("categoryID", category.getID());
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
