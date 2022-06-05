package com.example.madproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class QuizFragment extends Fragment implements View.OnClickListener {

    TextView quesNo;
    TextView questions, check_ans;
    Button opt1, opt2, opt3, opt4;
    Button confirm, check;

    int result = 0;
    int totalQues = ques.questions.length;
    int currQues = 0;
    int tmp_total_ques = 0;
    String sel = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        //quesNo = findViewById(R.id.ques_no);
        questions = view.findViewById(R.id.ques);
        opt1 = view.findViewById(R.id.opt1);
        opt2 = view.findViewById(R.id.opt2);
        opt3 = view.findViewById(R.id.opt3);
        opt4 = view.findViewById(R.id.opt4);
        confirm = view.findViewById(R.id.confirm);
        check = view.findViewById(R.id.check);
        //check_ans = getView().findViewById(R.id.check_ans);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        confirm.setOnClickListener(this);
        check.setOnClickListener(this);

        newQuestion();

        // Inflate the layout for this fragment
        return view;

    }


    @Override
    public void onClick(View view) {

        opt1.setBackgroundColor(Color.BLACK);
        opt2.setBackgroundColor(Color.BLACK);
        opt3.setBackgroundColor(Color.BLACK);
        opt4.setBackgroundColor(Color.BLACK);

        opt1.setTextColor(Color.WHITE);
        opt2.setTextColor(Color.WHITE);
        opt3.setTextColor(Color.WHITE);
        opt4.setTextColor(Color.WHITE);


        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.confirm) {
            if (sel.equals(ques.correct[currQues])) {
                result++;
            }
            currQues++;
            newQuestion();


        } else if(clickedButton.getId() == R.id.confirm) {
            if (sel.equals(ques.correct[currQues])) {
                clickedButton.setBackgroundColor(Color.RED);
            }else{
                clickedButton.setBackgroundColor(Color.GREEN);
            }

        }else {
            sel = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.YELLOW);
            clickedButton.setTextColor(Color.BLACK);
        }

    }

    void newQuestion ()
    {
        if (currQues == totalQues) {
            tmp_total_ques = totalQues;
            totalQues = 0;
            quizOver();
            return;
        }

        questions.setText(ques.questions[currQues]);
        opt1.setText(ques.options[currQues][0]);
        opt2.setText(ques.options[currQues][1]);
        opt3.setText(ques.options[currQues][2]);
        opt4.setText(ques.options[currQues][3]);



    }


    void quizOver ()
    {

        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);
        opt4.setVisibility(View.GONE);
        check.setVisibility(View.GONE);

        questions.setText("Your Got " + result + " Out Of " + tmp_total_ques);
        confirm.setText("Done");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage1();
            }
        });

    }



    public void openHomepage1(){
        Intent intent1 = new Intent(getActivity(), HomePage.class);
        startActivity(intent1);
    }
}