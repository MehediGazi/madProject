package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LearnVocab extends AppCompatActivity {

    RecyclerView rv;
    String words[], def[];

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
    }
}