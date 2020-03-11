package com.kimbriant.guessthatquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play;
    Button settings;
    Button about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play);
        settings = findViewById(R.id.settings);
        about = findViewById(R.id.about);
        play.setWidth(300);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent games = new Intent(MainActivity.this, GameActivity.class);
                startActivity(games);
            }
        });
    }
}
