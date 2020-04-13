package com.kimbriant.guessthatquote;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PickingActivity extends AppCompatActivity {
    Button firstButton, secondButton, thirdButton, fourthButton;
    TextView title, quote;
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
    }
}
