package com.example.madproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperQuiz extends SQLiteOpenHelper {
    public DBHelperQuiz(Context context) {
        super(context, "Quizdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DBQ) {
        DBQ.execSQL("create Table quiz(id INTEGER PRIMARY KEY AUTOINCREMENT, ques CHAR(100), option1 TEXT, option2 TEXT, option3 TEXT, option4 TEXT, answer TEXT, quizno INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DBQ, int i, int ii) {
        DBQ.execSQL("drop Table if exists quiz");
    }

    public Boolean insertuserdata(String ques, String option1, String option2, String option3, String option4, String answer, int quizno) {
        SQLiteDatabase DBQ = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ques", ques);
        contentValues.put("option1", option1);
        contentValues.put("option2", option2);
        contentValues.put("option3", option3);
        contentValues.put("option4", option4);
        contentValues.put("answer", answer);
        contentValues.put("quizno", quizno);
        long result = DBQ.insert("quiz", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata(int quizno) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        Cursor cursor = DB.rawQuery("Select * from quiz where quizno = ?", new String[]{String.valueOf(quizno)});
        return cursor;
    }

}