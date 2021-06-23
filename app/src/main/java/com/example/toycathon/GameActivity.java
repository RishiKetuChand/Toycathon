package com.example.toycathon;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.toycathon.dto.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    ImageView settings, grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        List<Questions> questionData = getIntent().getExtras().getParcelableArrayList("courses");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        settings = findViewById(R.id.settings_img);
        grid = findViewById(R.id.grid_img);


        Collections.shuffle(questionData);

        QuestionsFragment questionsFragment = new QuestionsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("questionModel", (ArrayList<? extends Parcelable>) questionData);
        questionsFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, questionsFragment, null);
        fragmentTransaction.commit();

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.animate().rotation(360f).setDuration(1000);
            }
        });
    }
}