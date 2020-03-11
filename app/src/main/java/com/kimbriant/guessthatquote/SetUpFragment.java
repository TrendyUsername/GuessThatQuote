package com.kimbriant.guessthatquote;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.PreferenceManager;
import androidx.fragment.app.Fragment;

public class SetUpFragment extends Fragment {
    TextView setText;
    EditText name;
    Button confirm;
    SharedPreferences player_data;
    SharedPreferences.Editor player_data_editor;
    private String _myTag;
    boolean submitted;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(R.layout.set_name container, false);
        Context globalContext = getActivity();
        player_data = PreferenceManager.getDefaultSharedPreferences(globalContext);
        player_data_editor = player_data.edit();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setText = view.findViewById(R.id.setTitle);
        name = view.findViewById(R.id.name);
        confirm = view.findViewById(R.id.confirm);
    }

    private class ClickListening implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String actualName = name.getText().toString();
            player_data_editor.putString("name", actualName);
            player_data_editor.commit();
            submitted = true;
        }
    }

    public void set_myTag(String value) {
        if("".equals(value)) {
            return;
        }
        _myTag = value;
    }
}
