package com.kimbriant.guessthatquote;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PickingActivity extends AppCompatActivity {
    Button firstButton, secondButton, thirdButton, fourthButton;
    TextView title, quote;
    private ArrayList<QuestionsAndAnswers> questionsAndAnswers;
    private SharedPreferences playerData;
    private SharedPreferences.Editor playerManager;
    private String done;
    Resources resources;
    private String[] serializedQuestionsAndAnswers;
    Gson gson = new Gson();
    private int ran;
    private int shqip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_game);
        firstButton = findViewById(R.id.firstOption);
        secondButton = findViewById(R.id.secondOption);
        thirdButton = findViewById(R.id.thirdOption);
        fourthButton = findViewById(R.id.fourthOption);
        title = findViewById(R.id.title);
        quote = findViewById(R.id.quote);
        playerData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        playerManager = playerData.edit();
        playerManager.putInt("score", 0);
        playerManager.commit();
        title.setText("Score " + playerData.getInt("score", 0));
        resources = getResources();
        serializedQuestionsAndAnswers = resources.getStringArray(R.array.questions_and_answers_in_JSON_format);
        initiateArrayOfQuestions();


        while(containsQuestionNotSolved(questionsAndAnswers) && shqip == 0) {
            QuestionsAndAnswers randomQuestion = questionsAndAnswers.get(new Random().nextInt(questionsAndAnswers.size()));
            if(randomQuestion.isSolved()) {
                questionsAndAnswers.remove(randomQuestion);
                while(randomQuestion.isSolved()) {
                    randomQuestion = questionsAndAnswers.get(new Random().nextInt(questionsAndAnswers.size()));
                }
            } else {
                quote.setText(randomQuestion.getQuote());
                firstButton.setText(randomQuestion.getAnswers()[0]);
                secondButton.setText(randomQuestion.getAnswers()[1]);
                thirdButton.setText(randomQuestion.getAnswers()[2]);
                fourthButton.setText(randomQuestion.getAnswers()[3]);
                shqip++;
            }
        }
    }

    public boolean containsQuestionNotSolved(final List<QuestionsAndAnswers> list) {
        for(QuestionsAndAnswers qanda : list) {
            if(!qanda.isSolved()) {
                return true;
            }
        }
        return false;
    }

    private void initiateArrayOfQuestions() {
        if(ran == 0) {
            questionsAndAnswers = new ArrayList<QuestionsAndAnswers>();
            for (int i = 0; i < serializedQuestionsAndAnswers.length; i++) {
                questionsAndAnswers.add(gson.fromJson(serializedQuestionsAndAnswers[i], QuestionsAndAnswers.class));
            }
        }
        ran++;

    }
}
