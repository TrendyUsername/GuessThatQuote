package com.kimbriant.guessthatquote;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.sql.SQLOutput;
import java.util.Map;


public class NextActivity extends AppCompatActivity {
    private SharedPreferences playerData;
    private SharedPreferences.Editor playerManager;
    private TextView verify, textHolder;
    private Button clickNext;
    private String author;
    private boolean trueornot;
    private String quote;
    private Map<String, ?> keys;
    private int numOfRemainingQs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yup);
        verify = findViewById(R.id.verify);
        textHolder = findViewById(R.id.quoteholder);
        clickNext = findViewById(R.id.clickNext);
        playerData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        playerManager = playerData.edit();
        keys = playerData.getAll();
        if(getIntent().getStringExtra("right") != null) {
            author = getIntent().getStringExtra("right");
            quote = getIntent().getStringExtra("rightquote");
            trueornot = true;
        } else {
            author = getIntent().getStringExtra("wrong");
            quote = getIntent().getStringExtra("wrongquote");
            trueornot = false;
        }
        if (trueornot) {
            textHolder.setText("Yup. Y'know, " + author + " " + "said " + quote);
            verify.setText(playerData.getString("name", "derryinireland") + " has " + playerData.getInt("score", 1111) + " point.");
            Log.d("[SCORE]", "" + playerData.getInt("score", -9));
        } else {
            textHolder.setText("Well.. you were wrong, but " + author + " said " + quote);
            verify.setText(playerData.getString("name", "derryinireland") + " has " + playerData.getInt("score", 1111) + " point.");
        }
        clickNext.setOnClickListener(new GetBackToGaming());
    }

    class GetBackToGaming implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            System.out.println("Let's get back home. :))");
            for(Map.Entry<String, ?> entry : keys.entrySet()) {
                    if(entry.getKey().contains("||{}")) {
                        numOfRemainingQs++;
                    }
            }
            callHomeToPickingActivity();
        }
    }

    public void callHomeToPickingActivity() {
        Intent goHome = new Intent(this, PickingActivity.class);
        startActivity(goHome);
        Log.d("tag", "load home");
    }
}
