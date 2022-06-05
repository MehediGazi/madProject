package com.example.madproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String words[], def[];
    Context context;

    public MyAdapter(Context ct, String w[], String d[]){
        context = ct;
        words = w;
        def = d;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt1.setText(words[position]);
        holder.txt2.setText(def[position]);
    }

    @Override
    public int getItemCount() {
        return words.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt1, txt2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt1 = itemView.findViewById(R.id.words_txt);
            txt2 = itemView.findViewById(R.id.def_txt);
        }
    }
}
