package com.kimbriant.guessthatquote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {
    TextView title;
    TextView quote;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.quote_game, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        title = (TextView)view.findViewById(R.id.title);
    }
}
