package com.example.toycathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.toycathon.dto.Questions;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuestionsFragment extends Fragment implements View.OnClickListener {
    TextView question, choice01, choice02, choice03, choice04, number;
    ImageView thumb;
    List<Questions> data;
    String num = "No.";
    LottieAnimationView lottieAnimationView;
    int i = 0;
    int numNo = i + 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        ;
        // Inflate the layout for this fragment

        Bundle recieveData = getArguments();
        data = recieveData.getParcelableArrayList("questionModel");

        question = view.findViewById(R.id.question);
        choice01 = view.findViewById(R.id.choice1);
        choice02 = view.findViewById(R.id.choice2);
        choice03 = view.findViewById(R.id.choice3);
        choice04 = view.findViewById(R.id.choice4);
        thumb = view.findViewById(R.id.imageView);
        number = view.findViewById(R.id.number);
        lottieAnimationView = view.findViewById(R.id.animationView);
        lottieAnimationView.setVisibility(View.GONE);

        number.setText(num + numNo);
        question.setText(data.get(i).getQuestion());
        choice01.setText(data.get(i).getChoice01());
        choice02.setText(data.get(i).getChoice02());
        choice03.setText(data.get(i).getChoice03());
        choice04.setText(data.get(i).getChoice04());
        Picasso.get().load(data.get(i).getThumb()).into(thumb);

        return view;


    }

    private void checkAnswer(TextView selectedOption) {
        if (selectedOption.getText().toString().equals(data.get(i).getCrtAns())) {
            //correct
        } else {
            //incorrect
        }
    }

    @Override
    public void onClick(View v) {
        if (choice01.getText().toString().equals(data.get(i).getCrtAns())) {
            lottieAnimationView.setVisibility(View.VISIBLE);

        } else if (choice02.getText().toString().equals(data.get(i).getCrtAns())) {
            lottieAnimationView.setVisibility(View.VISIBLE);

        } else if (choice03.getText().toString().equals(data.get(i).getCrtAns())) {
            lottieAnimationView.setVisibility(View.VISIBLE);

        } else {
            lottieAnimationView.setVisibility(View.VISIBLE);

        }
    }
}