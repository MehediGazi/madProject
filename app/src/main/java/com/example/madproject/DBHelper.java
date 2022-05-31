package com.example.madproject;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(phone TEXT primary key, name TEXT, dob TEXT, pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String name, String phone, String dob, String pass) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", phone);
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("pass", pass);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getdata(String phone) {
        SQLiteDatabase DB = this.getWritableDatabase();
        //Cursor cursor = DB.rawQuery("Select * from Userdetails", null);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where phone = ?", new String[]{phone});
        return cursor;
    }

}