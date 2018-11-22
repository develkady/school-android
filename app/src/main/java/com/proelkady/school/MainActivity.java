package com.proelkady.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLoginClick(View view){
//        Request request = new Request()
    }
}
