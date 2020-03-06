package com.kimbriant.guessthatquote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}
