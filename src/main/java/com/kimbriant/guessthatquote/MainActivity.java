package com.kimbriant.guessthatquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.preference.*;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button settings;
    Button about;
    Button resetter;
    TextView display;
    Preference playerData;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        play.setWidth(300);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent games = new Intent(MainActivity.this, SetUpActivity.class);
                startActivity(games);

            }
        });
    }
}
