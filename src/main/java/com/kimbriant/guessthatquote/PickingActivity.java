package com.kimbriant.guessthatquote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private QuestionsAndAnswers randomQuestion;
    private Intent intent;
    private Map <String, ?> keys;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ran = 0;
        setContentView(R.layout.quote_game);
        firstButton = findViewById(R.id.firstOption);
        secondButton = findViewById(R.id.secondOption);
        thirdButton = findViewById(R.id.thirdOption);
        fourthButton = findViewById(R.id.fourthOption);
        title = findViewById(R.id.title_end);
        quote = findViewById(R.id.quote);
        playerData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        playerManager = playerData.edit();
        if(playerData.getInt("numTimesRan", 999) == 999) { //if is default
            playerManager.putInt("score", 0);
            playerManager.putInt("numTimesRan", 0);
            playerManager.commit();
        }
        title.setText("Score " + playerData.getInt("score", 999));
        resources = getResources();
        serializedQuestionsAndAnswers = resources.getStringArray(R.array.questions_and_answers_in_JSON_format);
        if(playerData.getString("currQue", "oooo") != "oooo") {
            Type listOfMyQs = new TypeToken<ArrayList<QuestionsAndAnswers>>() {}.getType();
        }
        if(playerData.getInt("numTimesRan", 0) == 0) {
            Log.v("[AHHH]", "" + playerData.getInt("numTimesRan", 11));
            initiateArrayOfQuestions();
        } else {
            questionsAndAnswers = gson.fromJson(playerData.getString("currQue", "pool"), new TypeToken<ArrayList<QuestionsAndAnswers>>() {}.getType());
        }
        for(int q = 0; q < questionsAndAnswers.size(); q++) {
            playerManager.putString("||{}" + questionsAndAnswers.get(q).getQuote(), questionsAndAnswers.get(q).getAnswers()[questionsAndAnswers.get(q).getSolution()] + "");
        }
        keys = playerData.getAll();
        intent = new Intent(this, NextActivity.class);


        if(!questionsAndAnswers.isEmpty()) {
            randomQuestion = questionsAndAnswers.get(new Random().nextInt(questionsAndAnswers.size()));
            randomQuestion = questionsAndAnswers.get(new Random().nextInt(questionsAndAnswers.size()));
            quote.setText(randomQuestion.getQuote());
            firstButton.setText(randomQuestion.getAnswers()[0]);
            secondButton.setText(randomQuestion.getAnswers()[1]);
            thirdButton.setText(randomQuestion.getAnswers()[2]);
            fourthButton.setText(randomQuestion.getAnswers()[3]);
            firstButton.setOnClickListener( new ImpressiveButtonClick());
            secondButton.setOnClickListener(new ImpressiveButtonClick());
            thirdButton.setOnClickListener(new ImpressiveButtonClick());
            fourthButton.setOnClickListener(new ImpressiveButtonClick());
            questionsAndAnswers.remove(randomQuestion);
            playerManager.remove(randomQuestion.getQuote());
            String removedArrList = gson.toJson(questionsAndAnswers);
            Log.d("the list", questionsAndAnswers.toString());
            if(playerData.getInt("numTimesRan", 1992) != 0) {
                String gsonify = playerData.getString("currQue", "I can put anything in here, right..");
                ArrayList<QuestionsAndAnswers> awesome = gson.fromJson(gsonify, new TypeToken<ArrayList<QuestionsAndAnswers>>() {
                }.getType());
                awesome.remove(randomQuestion);
                String jsonfromgson = gson.toJson(awesome);
                playerManager.putString("currQue", jsonfromgson);
                Log.v("[LIST OF Qs]", jsonfromgson);
            }
            playerManager.putString("currQue", removedArrList);
            playerManager.putInt("numTimesRan", playerData.getInt("score", 0) + 1);
            shqip++;
        } else {
            Intent i = new Intent(this, FinishedActivity.class);
            startActivity(i);
        }
    }

//    @Override
//    public void onSaveInstanceState(@NonNull  stentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putInt("numrun", ran++);
//    }

    public boolean containsQuestionNotSolved(final List<QuestionsAndAnswers> list) {
        for(QuestionsAndAnswers qanda : list) {
            if(!qanda.isSolved()) {
                return true;
            }
        }
        return false;
    }

    private void initiateArrayOfQuestions() {
        if(ran < 1) {
            questionsAndAnswers = new ArrayList<QuestionsAndAnswers>();
            for (int i = 0; i < serializedQuestionsAndAnswers.length; i++) {
                questionsAndAnswers.add(gson.fromJson(serializedQuestionsAndAnswers[i], QuestionsAndAnswers.class));
            }
            String toJson = gson.toJson(questionsAndAnswers);
            playerManager.putString("currQue", toJson);

        }
        ran++;

    }

    class ImpressiveButtonClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.firstOption:
                    if(randomQuestion.getSolution() == 0) {
                        System.out.println("Yes!");
                        playerManager.putInt("score", playerData.getInt("score", 69000) + 1);
                        Log.d("[SCORE]", "" + playerData.getInt("score", 99));
                        playerManager.commit();
                        System.out.println(playerData.getInt("score", 1341540189));
                        intent.putExtra("right", randomQuestion.getAnswers()[0]);
                        intent.putExtra("rightquote", randomQuestion.getQuote());
                        startActivity(intent);
                    } else {
                        System.out.println("No!");
                        intent.putExtra("wrong", randomQuestion.getAnswers()[randomQuestion.getSolution()]);
                        intent.putExtra("wrongquote", randomQuestion.getQuote());
                        startActivity(intent);
                    }
                    break;
                case R.id.secondOption:
                    if(randomQuestion.getSolution() == 1) {
                        System.out.println("Yes. Author 2");
                        playerManager.putInt("score", playerData.getInt("score", 69000) + 1);
                        playerManager.commit();
                        intent.putExtra("right", randomQuestion.getAnswers()[1]);
                        intent.putExtra("rightquote", randomQuestion.getQuote());
                        System.out.println(playerData.getInt("score", 1341540189));
                        startActivity(intent);
                    } else {
                        intent.putExtra("wrong", randomQuestion.getAnswers()[randomQuestion.getSolution()]);
                        intent.putExtra("wrongquote", randomQuestion.getQuote());
                        System.out.println("No!");
                        startActivity(intent);
                    }
                    break;
                case R.id.thirdOption:
                    if(randomQuestion.getSolution() == 2) {
                        System.out.println("Yes. Author 3");
                        playerManager.putInt("score", playerData.getInt("score", 69000) + 1);
                        playerManager.commit();
                        intent.putExtra("right", randomQuestion.getAnswers()[2]);
                        intent.putExtra("rightquote", randomQuestion.getQuote());
                        System.out.println(playerData.getInt("score", 1341540189));
                        startActivity(intent);
                    } else {
                        intent.putExtra("wrong", randomQuestion.getAnswers()[randomQuestion.getSolution()]);
                        intent.putExtra("wrongquote", randomQuestion.getQuote());
                        System.out.println("No!");
                        startActivity(intent);
                    }
                    break;
                case R.id.fourthOption:
                    if(randomQuestion.getSolution() == 3) {
                        System.out.println("Yes. Author 4.");
                        playerManager.putInt("score", playerData.getInt("score", 69000) + 1);
                        playerManager.commit();
                        intent.putExtra("right", randomQuestion.getAnswers()[3]);
                        intent.putExtra("rightquote", randomQuestion.getQuote());
                        System.out.println(playerData.getInt("score", 1341540189));
                        startActivity(intent);
                    } else {
                        intent.putExtra("wrong", randomQuestion.getAnswers()[randomQuestion.getSolution()]);
                        intent.putExtra("wrongquote", randomQuestion.getQuote());
                        System.out.println("Capitalism");
                        startActivity(intent);
                    }
                    break;
            }
        }
    }
}
