package com.kimbriant.guessthatquote;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private Button imListeningToYou;
    private SharedPreferences playerData;
    private SharedPreferences.Editor playerManager;
    private TextView display;
    private Context ctx;
    private ArrayList<QuestionsAndAnswers> questionsAndAnswers;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yup);
        imListeningToYou = findViewById(R.id.clickNext);
        display = findViewById(R.id.verify);
        ctx = getApplicationContext();
        playerData = PreferenceManager.getDefaultSharedPreferences(ctx);
        String username = playerData.getString("name", "harold");

    }
}
