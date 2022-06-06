package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;




public class qtestActivity extends AppCompatActivity implements View.OnClickListener{

    //TextView quesNo;
    TextView questions, correct, incorrect, corrans;
    Button opt1, opt2, opt3, opt4;
    Button confirm, next;

    int result = 0;
    int totalQues = ques.questions.length;
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

        ques quecal = new ques();

        DBHelperQuiz DBQ2;
        DBQ2 = new DBHelperQuiz(this);
        String ques1, opt1, opt2, opt3, opt4, ans;

        Cursor res = DBQ2.getdata(1);

        if (res.getCount() == 0) {
            Toast.makeText(qtestActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<String> ques3 = new ArrayList<String>();
        ArrayList<String> opt13 = new ArrayList<String>();
        ArrayList<String> opt23 = new ArrayList<String>();
        ArrayList<String> opt33 = new ArrayList<String>();
        ArrayList<String> opt43 = new ArrayList<String>();
        ArrayList<String> ans3 = new ArrayList<String>();

        while(res.moveToNext()){
            ques1 = res.getString(1);
            opt1 = res.getString(2);
            opt2 = res.getString(3);
            opt3 = res.getString(4);
            opt4 = res.getString(5);
            ans = res.getString(6);

//            ques3.add(ques1);
//            opt13.add(opt1);
//            opt23.add(opt2);
//            opt33.add(opt3);
//            opt43.add(opt4);
//            ans3.add(ans);

            //quecal.getvals(ques1, opt1, opt2, opt3, opt4, ans);

        }

//        ques3 = quecal.ques3;
//        opt13 = quecal.opt13;
//        opt23 = quecal.opt23;
//        opt33 = quecal.opt33;
//        opt43 = quecal.opt43;
//        ans3 = quecal.ans3;

        //public static String[] ques4 = new String[ques3.size()];


        //quesNo.setText("Number of Question: " + totalQues);
        newQuestion(ques3, opt13, opt23, opt33, opt43, ans3);



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
            if (sel.equals(ques.correct[currQues])) {
                result++;
            }
            //answerPage();

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


    void answerPage(ArrayList<String> ques3, ArrayList<String> opt13, ArrayList<String> opt23, ArrayList<String> opt33, ArrayList<String> opt43, ArrayList<String> ans3){
        opt1.setVisibility(View.GONE);
        opt2.setVisibility(View.GONE);
        opt3.setVisibility(View.GONE);
        opt4.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);
        confirm.setVisibility(View.INVISIBLE);
        questions.setVisibility(View.INVISIBLE);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currQues++;
                newQuestion(ques3, opt13, opt23, opt33, opt43, ans3);
            }
        });

        if (sel.equals(ques.correct[currQues])) {
            correct.setVisibility(View.VISIBLE);
        }else{
            incorrect.setVisibility(View.VISIBLE);
            corrans.setVisibility(View.VISIBLE);
            corrans.setText("Correct Answer is: "+ques.correct[currQues]);
        }

        if (currQues+1 == totalQues) {
            next.setText("DONE");
        }

    }


    void newQuestion (ArrayList<String> ques3, ArrayList<String> opt13, ArrayList<String> opt23, ArrayList<String> opt33, ArrayList<String> opt43, ArrayList<String> ans3)
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

        questions.setText(ques3.get(currQues));
        opt1.setText(opt13.get(currQues));
        opt1.setText(opt23.get(currQues));
        opt1.setText(opt33.get(currQues));
        opt1.setText(opt43.get(currQues));
        opt1.setText(ans3.get(currQues));

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