package com.kimbriant.guessthatquote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {
    TextView title;
    TextView quote;
    Button firstOption;
    Button secondOption;
    Button thirdOption;
    Button fourthOption;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quote_game, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        title = (TextView)view.findViewById(R.id.title_end);
        quote = (TextView)view.findViewById(R.id.quote);
        firstOption = (Button)view.findViewById(R.id.firstOption);
        secondOption = (Button)view.findViewById(R.id.secondOption);
        thirdOption = (Button)view.findViewById(R.id.thirdOption);
        fourthOption = (Button)view.findViewById(R.id.fourthOption);
    }
}
