package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Referencing and setting onClickListener
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
            }
        });

        Button info = (Button) findViewById(R.id.button);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent intent = new Intent(mContext, DetailsActivity.class);
                mContext.startActivity(intent);
            }
        });

        Button munic = (Button) findViewById(R.id.municp);

        munic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent intent = new Intent(mContext, MunipActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * This method checks the answer and give toast message of scores
     */
    private void checkAnswers() {
        //Getting answers for question one
        boolean isOptionAChecked = binding.questionOne.oneOptionA.isChecked();
        boolean isOptionBChecked = binding.questionOne.oneOptionB.isChecked();
        boolean isOptionCChecked = binding.questionOne.oneOptionC.isChecked();

        //For question two
        int checkedIdForTwo = binding.questionTwo.twoOptions.getCheckedRadioButtonId();

        //For question three
        String answerThree = binding.questionThree.threeAnswer.getText().toString().toLowerCase().trim();
        //For question four
        String answerFour = binding.questionFour.fourAnswer.getText().toString().toLowerCase().trim();

        //For question five
        int checkedIdForFive = binding.questionFive.fiveOptions.getCheckedRadioButtonId();
        //For question six
        int checkedIdForSix = binding.questionSix.sixOptions.getCheckedRadioButtonId();

        int score = calculateScore(
                isOptionAChecked,
                isOptionBChecked,
                isOptionCChecked,
                checkedIdForTwo,
                answerThree,
                answerFour,
                checkedIdForFive,
                checkedIdForSix
        );

        if (score == -1) {
            Toast.makeText(this, getString(R.string.attempt), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, getString(R.string.score).replace("#", String.valueOf(score*10)), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Takes values of each question and checks them. If they are correct score is increased by 1
     */
    private int calculateScore(boolean oneA, boolean oneB, boolean oneC, int idTwo, String three, String four, int idFive, int idSix) {
        int score = 0;
        //Check if all questions are attempted if not return -1 rest handled by checkAnswers()
        if (!oneA && !oneB && !oneC || idTwo == -1 || three.equals("") || four.equals("") || idFive == -1 || idSix == -1) {
            score = -1;
        } else {
            if (oneA && !oneB && oneC) {
                score++;
            }
            if (idTwo == R.id.two_d) {
                score++;
            }
            if (three.equals("aedes")) {
                score++;
            }
            if (four.equals("platelet")) {
                score++;
            }
            if (idFive == R.id.five_b) {
                score++;
            }
            if (idSix == R.id.six_b) {
                score++;
            }
        }

        return score;
    }
}
