package com.raksoct.ibonapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnSingle, btnMulti;
    ImageView imgBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set elements
        btnSingle = (Button) findViewById(R.id.btnSingle);
        btnMulti = (Button) findViewById(R.id.btnMultiplayer);
        imgBackground = (ImageView) findViewById(R.id.imgBackground);

        //for screen background to stretch
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height = display.getHeight();
        imgBackground.setScaleType(ImageView.ScaleType.FIT_XY);
        imgBackground.setMinimumWidth(width);
        imgBackground.setMinimumHeight(height);
        imgBackground.setMaxWidth(width);
        imgBackground.setMaxHeight(height);


        //listeners
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                setMode(1);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMode(2);
            }
        });

    }

    private void setMode(int mode)
    {
        Intent i;
        if (mode == 1)
        {
            i = new Intent(this, SinglePlayerMain.class);
        }
        else
        {
            //Toast.makeText(this, "This mode is not ready yet.", Toast.LENGTH_LONG).show();
            i = new Intent(this, MultiPlayerMain.class);
        }
        this.startActivity(i);
    }


}
