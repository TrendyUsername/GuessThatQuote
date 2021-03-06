package com.kimbriant.guessthatquote;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class SetUpActivity extends AppCompatActivity implements SetUpFragment.PassMeData {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actual_set_name);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        assert fragment.getTag() != null;
    }

    @Override
    public void passMeData(String data) {
        Log.d("LOG", "WASS?");
        Intent switchToPicker = new Intent(this, PickingActivity.class);
        startActivity(switchToPicker);
    }

}
