package com.example.bojan.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String messageText = intent.getStringExtra("EXTRA_MESSAGE");

        TextView textView = findViewById(R.id.textView2);
        textView.setText(messageText);

    }
}
