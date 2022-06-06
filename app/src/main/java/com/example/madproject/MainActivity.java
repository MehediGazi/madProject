package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button loginBtn, signupBtn;
    public EditText phone, pass1;
    public TextView forgot;
    String phoneDb = "";
    String passDb = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Login Notify", "Login Notify",  NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =  getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        signupBtn = findViewById(R.id.signup_btn);
        loginBtn = findViewById(R.id.login_btn);
        phone = findViewById(R.id.phone_no);
        pass1 = findViewById(R.id.pass);
        forgot = findViewById(R.id.forgot);

        DBHelper DB2;
        DB2 = new DBHelper(this);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneTxt = phone.getText().toString();
                String passTxt = pass1.getText().toString();

                Cursor res = DB2.getdata(phoneTxt);

                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
                    return;
                }
                while(res.moveToNext()){
                    phoneDb = res.getString(0);
                    passDb = res.getString(3);
                }

                if(passTxt.equals(passDb)){

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "Login Notify");
                    builder.setContentTitle("Login Notification");
                    builder.setContentText("You Have Been Logged In Successfully");
                    builder.setSmallIcon(R.drawable.icon);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                    managerCompat.notify(1, builder.build());

                    openHomepage();
                }else{
                    Toast.makeText(MainActivity.this, "Wrong Password, Try Again", Toast.LENGTH_SHORT).show();
                    pass1.setText("");
                }

                forgot.setText(phoneDb+", "+passDb+"---"+phoneTxt+", "+passTxt);

            }
        });

    }

    public void openSignUp(){
        Intent intent2 = new Intent(this, SignUpActivity.class);
        startActivity(intent2);
    }

    public void openHomepage(){
        Intent intent3 = new Intent(this, HomePage.class);
        startActivity(intent3);
    }
}