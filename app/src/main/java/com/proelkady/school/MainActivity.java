package com.proelkady.school;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    AppCompatEditText email;
    AppCompatEditText pass;
    RelativeLayout relativeLayout;
    TextInputLayout emailLayout;
    TextInputLayout passLayout;
    AppCompatButton logButton;
    AppCompatTextView forget;
    AppCompatButton signUp;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LogIn or SignUp");


        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        email = (AppCompatEditText) findViewById(R.id.email_TextField);
        emailLayout = (TextInputLayout) findViewById(R.id.email_TextInputLayout);
        pass = (AppCompatEditText) findViewById(R.id.password_TextField);
        passLayout = (TextInputLayout) findViewById(R.id.password_TextInputEditText);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        logButton = (AppCompatButton) findViewById(R.id.log_btn);
        forget = (AppCompatTextView) findViewById(R.id.forget_textView);
        signUp = (AppCompatButton) findViewById(R.id.signUp_btn);




        relativeLayout.setOnClickListener(null);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (email.getText().toString().isEmpty()) {

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("please enter your username!");

                } else {

                    emailLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (pass.getText().toString().isEmpty()) {

                    passLayout.setErrorEnabled(true);
                    passLayout.setError("please enter your password!");

                } else {

                    passLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "forget", Toast.LENGTH_SHORT).show();

            }
        });


        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userEmail = email.getText().toString();
                String Passw = pass.getText().toString();

                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME+" WHERE "+DatabaseHelper.col3+" =? AND "+DatabaseHelper.col4+" =? ",new String[]{userEmail,Passw});

                if(cursor != null) {

                    if(cursor.getCount() > 0){

                        Toast.makeText(MainActivity.this, "Login successfully", Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });



    }

}
