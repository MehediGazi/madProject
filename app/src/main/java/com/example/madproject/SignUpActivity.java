package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
//import android.widget.TextView;

//import com.google.android.material.textfield.TextInputLayout;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    public EditText name, phone, dob, pass;
    //public RadioButton gender;
    public Button loginBtn2, signupBtn2;

    //FirebaseDatabase rootNode;
    //DatabaseReference reference;

    DBHelper DB;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loginBtn2 = findViewById(R.id.login_btn2);
        signupBtn2 = findViewById(R.id.signup_btn2);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone_no);
        dob = findViewById(R.id.dob);
        pass = findViewById(R.id.pass);
        //gender = findViewById(R.id.gen);

        DB = new DBHelper(this);

        signupBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference("users");

                String name2, phone2, dob2, pass2;

                name2 = name.getText().toString();
                phone2 = phone.getText().toString();
                dob2 = dob.getText().toString();
                //gender2 = gender.getText().toString();
                pass2 = pass.getText().toString();

                //UserHelper userHelper = new UserHelper(name2, phone2, dob2, pass2);

                //reference.child(phone2).setValue(userHelper);

                Boolean checkinsertdata = DB.insertuserdata(name2, phone2, dob2, pass2);
                if (checkinsertdata == true) {
                    Toast.makeText(SignUpActivity.this, "User has been registered, Now Login", Toast.LENGTH_SHORT).show();
                    openLogin();
                }else
                    Toast.makeText(SignUpActivity.this, "Error. Not Registered, Try again", Toast.LENGTH_SHORT).show();
            }
        });

        loginBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }

    public void openLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}