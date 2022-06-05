package com.example.madproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_settings, container, false);

        Button vocab;
        vocab = view.findViewById(R.id.vocab);

        vocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVocab();
            }
        });

        return view;
    }

    public void openVocab(){
        Intent intent2 = new Intent(getActivity(), LearnVocab.class);
        startActivity(intent2);
    }
}