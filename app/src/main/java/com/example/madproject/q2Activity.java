package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class q2Activity extends AppCompatActivity implements View.OnClickListener{

    //TextView quesNo;
    TextView questions, correct, incorrect, corrans;
    Button opt1, opt2, opt3, opt4;
    Button confirm, next;

    int result = 0;
    int totalQues = ques2.questions.length;
    int currQues = 0;
    int tmp_total_ques = 0;
    String sel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        Button exit = findViewById(R.id.exit);

        //quesNo = findViewById(R.id.ques_no);
        questions = findViewById(R.id.ques);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);
        confirm = findViewById(R.id.confirm);
        next = findViewById(R.id.next);
        correct = findViewById(R.id.correct);
        incorrect = findViewById(R.id.incorrect);
        corrans = findViewById(R.id.corrans);
        //check_ans = findViewById(R.id.check_ans);

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        confirm.setOnClickListener(this);
        next.setOnClickListener(this);

        //quesNo.setText("Number of Question: " + totalQues);
        newQuestion();



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homePage();
            }
        });
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
            if (sel.equals(ques2.correct[currQues])) {
                result++;
            }
            answerPage();

        } else if(clickedButton.getId() == R.id.confirm) {
            if (sel.equals(ques2.correct[currQues])) {
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


    void answerPage(){
        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);
        opt4.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.GONE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQues++;
                newQuestion();
            }
        });

        if (sel.equals(ques2.correct[currQues])) {
            correct.setVisibility(View.VISIBLE);
            questions.setVisibility(View.INVISIBLE);
        }else{
            incorrect.setVisibility(View.VISIBLE);
            corrans.setVisibility(View.VISIBLE);
            corrans.setText("Correct Answer is: "+ques2.correct[currQues]);
        }

        if (currQues+1 == totalQues) {
            next.setText("DONE");
        }

    }


    void newQuestion ()
    {
        opt1.setVisibility(View.VISIBLE);
        opt2.setVisibility(View.VISIBLE);
        opt3.setVisibility(View.VISIBLE);
        opt4.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.VISIBLE);
        questions.setVisibility(View.VISIBLE);
        corrans.setVisibility(View.GONE);

        if (currQues == totalQues) {
            tmp_total_ques = totalQues;
            totalQues = 0;
            quizOver();
            return;
        }

        next.setVisibility(View.GONE);
        correct.setVisibility(View.GONE);
        incorrect.setVisibility(View.GONE);

        questions.setText(ques2.questions[currQues]);
        opt1.setText(ques2.options[currQues][0]);
        opt2.setText(ques2.options[currQues][1]);
        opt3.setText(ques2.options[currQues][2]);
        opt4.setText(ques2.options[currQues][3]);

    }


    void quizOver ()
    {
        questions.setVisibility(View.VISIBLE);
        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);
        opt4.setVisibility(View.GONE);
        incorrect.setVisibility(View.GONE);
        correct.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
        confirm.setVisibility(View.GONE);

        questions.setText("Your Got " + result + " Out Of " + tmp_total_ques);

    }

    public void homePage(){
        Intent intent2 = new Intent(this, HomePage.class);
        startActivity(intent2);
    }
}