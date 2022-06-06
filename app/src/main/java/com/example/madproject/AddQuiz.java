package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuiz extends AppCompatActivity {

    EditText quis, opt1, opt2, opt3, opt4, ans, quizno;
    Button addquiz, exit;

    DBHelperQuiz DBQ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_quiz);

        quis = findViewById(R.id.quesadd);
        opt1 = findViewById(R.id.opt1add);
        opt2 = findViewById(R.id.opt2add);
        opt3 = findViewById(R.id.opt3add);
        opt4 = findViewById(R.id.opt4add);
        ans = findViewById(R.id.corransadd);
        quizno = findViewById(R.id.quizno);
        addquiz = findViewById(R.id.addquiz_btn);
        exit = findViewById(R.id.exit_btn);

        DBQ = new DBHelperQuiz(this);

        addquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String quis_s, opt1_s, opt2_s, opt3_s, opt4_s, ans_s, quizno_s;
                int quizno_i;

                quis_s = quis.getText().toString();
                opt1_s = opt1.getText().toString();
                opt2_s = opt2.getText().toString();
                opt3_s = opt3.getText().toString();
                opt4_s = opt4.getText().toString();
                ans_s = ans.getText().toString();
                quizno_s = quizno.getText().toString();
                quizno_i = Integer.parseInt(quizno_s);

                Boolean checkinsertdata = DBQ.insertuserdata(quis_s, opt1_s, opt2_s, opt3_s, opt4_s, ans_s, quizno_i);

                if (checkinsertdata == true) {
                    Toast.makeText(AddQuiz.this, "New question to Quiz-" + quizno_i + " has been added.", Toast.LENGTH_SHORT).show();
                    openAddQuiz();
                }else
                    Toast.makeText(AddQuiz.this, "Error. Question could not be added, Try again", Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    public void openAddQuiz(){
        Intent intent = new Intent(this, AddQuiz.class);
        startActivity(intent);
    }

    public void openHome(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}