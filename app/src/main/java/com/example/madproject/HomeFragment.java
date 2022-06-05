package com.example.madproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {


    private Activity view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button ques1, q2, q3, q4;

        ques1 = view.findViewById(R.id.q1);
        q2 = view.findViewById(R.id.q2);
        q3 = view.findViewById(R.id.q3);
        q4 = view.findViewById(R.id.q4);

        ques1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q1Page();
            }
        });

        return view;

    }

    public void q1Page(){
        Intent intent3 = new Intent(getActivity(), q1Activity.class);
        startActivity(intent3);
    }
}