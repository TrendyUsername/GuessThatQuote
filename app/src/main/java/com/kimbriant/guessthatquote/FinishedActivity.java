package com.kimbriant.guessthatquote;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;


public class FinishedActivity extends AppCompatActivity {
    private TextView title, score;
    private Button goBack;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finished);
        title = findViewById(R.id.title_end);
        score = findViewById(R.id.score);
        goBack = findViewById(R.id.getmeout);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        spEditor = sp.edit();

    }
}
