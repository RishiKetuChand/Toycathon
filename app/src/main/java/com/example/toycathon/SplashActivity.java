package com.example.toycathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toycathon.dto.Questions;
import com.example.toycathon.utilities.ApiHelper;
import com.example.toycathon.utilities.ServerCallback;

import java.util.ArrayList;
import java.util.List;


public class SplashActivity extends AppCompatActivity implements ServerCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ApiHelper helper = new ApiHelper(this);
        helper.fetchQuestions(this);
    }

    @Override
    public void onDataReceived(List<Questions> data) {
        Intent intent = new Intent(this, GameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("courses", (ArrayList<? extends Parcelable>) data);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }
}