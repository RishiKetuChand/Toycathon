package com.example.toycathon;

import android.animation.Animator;
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

public class QuestionsFragment extends Fragment {
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
        lottieAnimationView.setVisibility(View.INVISIBLE);

        number.setText(num + numNo);
        question.setText(data.get(i).getQuestion());
        choice01.setText(data.get(i).getChoice01());
        choice02.setText(data.get(i).getChoice02());
        choice03.setText(data.get(i).getChoice03());
        choice04.setText(data.get(i).getChoice04());
        Picasso.get().load(data.get(i).getThumb()).into(thumb);

        choice01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice01.getText().toString().equals(data.get(i).getCrtAns())) {
                    lottieAnimationView.setVisibility(View.VISIBLE);
                } else {
                    lottieAnimationView.setAnimation(R.raw.wrong);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                }
            }
        });

        choice02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice02.getText().toString().equals(data.get(i).getCrtAns())) {
                    lottieAnimationView.setVisibility(View.VISIBLE);
                } else {
                    lottieAnimationView.setAnimation(R.raw.wrong);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                }
            }
        });

        choice03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice03.getText().toString().equals(data.get(i).getCrtAns())) {
                    lottieAnimationView.setVisibility(View.VISIBLE);
                } else {
                    lottieAnimationView.setAnimation(R.raw.wrong);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                }
            }
        });

        choice04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice04.getText().toString().equals(data.get(i).getCrtAns())) {
                    lottieAnimationView.setVisibility(View.VISIBLE);
                } else {
                    lottieAnimationView.setAnimation(R.raw.wrong);
                    lottieAnimationView.setVisibility(View.VISIBLE);
                }
            }
        });


        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                lottieAnimationView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        return view;

    }


}