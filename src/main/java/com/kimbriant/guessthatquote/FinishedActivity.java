package com.kimbriant.guessthatquote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;


public class FinishedActivity extends AppCompatActivity {
    private TextView title, score;
    private int scoreRep;
    private Button goBack;
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;
    private String name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finished);
        title = findViewById(R.id.title_end);
        score = findViewById(R.id.score);
        goBack = findViewById(R.id.getmeout);
        sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        spEditor = sp.edit();
        name = sp.getString("name", "default_score");
        scoreRep = sp.getInt("score", 112);
        title.setText("OK... Let's see how you've done..");
        score.setText("Hmmm.. " + name + " got " + scoreRep + " points.");
        goBack.setText("Click here to go back home :-}");
        final Intent goBackHome = new Intent(this, MainActivity.class);
        spEditor.clear();
        spEditor.commit();
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(goBackHome);
            }
        });
    }
}
