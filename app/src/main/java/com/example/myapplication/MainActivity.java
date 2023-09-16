package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView welcome, clicks_left;
    private ImageButton egg;
    private ImageView morgan;
    private Button resetBtn;

    final int EGG_HP = 5;
    private int clicksCounter = EGG_HP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView) findViewById(R.id.welcome);
        clicks_left = (TextView) findViewById(R.id.clicks_left);
        egg = (ImageButton) findViewById(R.id.egg);
        morgan = (ImageView) findViewById(R.id.morgan);
        resetBtn = (Button) findViewById(R.id.reset);

        updateClicks();
    }

    public void showMorgan(View view)
    {
        clicksCounter--;
        if (clicksCounter > 0)
        {
            System.out.println("You clicked me!!");
            updateClicks();
            updateEgg();
        }
        else
        {
            egg.setVisibility(View.GONE);
            morgan.setVisibility(View.VISIBLE);
            welcome.setText(R.string.win_msg);
            clicks_left.setVisibility(View.GONE);
            resetBtn.setVisibility(View.VISIBLE);
        }
    }

    public void reset(View view)
    {
        clicksCounter = EGG_HP;
        updateClicks();
        egg.setVisibility(View.VISIBLE);
        morgan.setVisibility(View.GONE);
        welcome.setText(R.string.welcome);
        clicks_left.setVisibility(View.VISIBLE);
        resetBtn.setVisibility(View.GONE);
        egg.setImageResource(R.drawable.egg1);
    }

    public void updateClicks()
    {
        Resources res = getResources();
        String text = String.format(res.getString(R.string.clicks_left), clicksCounter);
        clicks_left.setText(text);
    }

    public void updateEgg()
    {
        // Get next image using the following resource ID
        egg.setImageResource(R.drawable.egg1 + EGG_HP - clicksCounter);
    }
}