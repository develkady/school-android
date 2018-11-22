package com.proelkady.school;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class SignupActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    AppCompatEditText username;
    AppCompatEditText password;
    AppCompatEditText email_et;
    AppCompatEditText confPass;
    TextInputLayout usernameLayout;
    TextInputLayout passwordLayout;
    TextInputLayout emailLayout;
    TextInputLayout confPassLayout;
    AppCompatButton signUpBtn;
    RelativeLayout signupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        openHelper = new DatabaseHelper(this);

        username = (AppCompatEditText) findViewById(R.id.user_TextField);
        usernameLayout = (TextInputLayout) findViewById(R.id.user_TextInputLayout);
        password = (AppCompatEditText) findViewById(R.id.pass_TextField);
        passwordLayout = (TextInputLayout) findViewById(R.id.pass_TextInputEditText);
        email_et = (AppCompatEditText) findViewById(R.id.email_TextField);
        emailLayout = (TextInputLayout) findViewById(R.id.email_TextInputLayout);
        confPass = (AppCompatEditText) findViewById(R.id.confpass_TextField);
        confPassLayout = (TextInputLayout) findViewById(R.id.confpass_TextInputEditText);
        signupLayout = (RelativeLayout) findViewById(R.id.signupLayout);

        signUpBtn = (AppCompatButton) findViewById(R.id.signup_btn);

        signupLayout.setOnClickListener(null);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (username.getText().toString().isEmpty()) {

                    usernameLayout.setErrorEnabled(true);
                    usernameLayout.setError("please enter your username!");

                } else {

                    usernameLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (email_et.getText().toString().isEmpty()) {

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("please enter your email!");

                } else {

                    emailLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (password.getText().toString().isEmpty()) {

                    passwordLayout.setErrorEnabled(true);
                    passwordLayout.setError("please enter your password!");

                } else {

                    passwordLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (confPass.getText().toString().isEmpty()) {

                    confPassLayout.setErrorEnabled(true);
                    confPassLayout.setError("password not matches!");

                } else {

                    confPassLayout.setErrorEnabled(false);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    db = openHelper.getWritableDatabase();

                    String name = username.getText().toString();
                    String email = email_et.getText().toString();
                    String pass = password.getText().toString();
                    insertData(name, email, pass);

                    Toast.makeText(SignupActivity.this, "Register successfully", Toast.LENGTH_SHORT).show();

            }

            private void insertData(String name, String email, String pass) {


                ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.col2, name);
                contentValues.put(DatabaseHelper.col3, email);
                contentValues.put(DatabaseHelper.col4, pass);

                long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

            }
        });




    }


}
