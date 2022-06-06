package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearnVocab extends AppCompatActivity {

    RecyclerView rv;
    String words[], def[];
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_vocab);

        rv = findViewById(R.id.rv);

        words = getResources().getStringArray(R.array.words);
        def = getResources().getStringArray(R.array.def);

        MyAdapter adapter = new MyAdapter(this, words, def);

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
            }
        });
    }

    void openHome(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}