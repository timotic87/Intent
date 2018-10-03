package com.example.bojan.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClicked(View v){

        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);

        if (editText.getText().toString().trim().length() == 0){

            textView.setText("Ukucaj svoje ime");
        }else {

            String messageForSecondActiviry = "hello "+editText.getText()+"!";


            // otvaranje aktivnosti---ekplicitni intent
            Intent intent = new Intent(this, SecondActivity.class);
            // slanje podataka u drugi activity
            intent.putExtra("EXTRA_MESSAGE", messageForSecondActiviry);
            startActivity(intent);
        }

    }

    public void sendToFriend(View v){
        EditText editText = findViewById(R.id.editText);
        TextView textView = findViewById(R.id.textView);

        if (editText.getText().toString().trim().length() == 0){
            textView.setText("Ukucaj svoje ime");
        }else {

            String messageForFriend = "Hello my friend. Is is "+editText.getText()+ ". I great you from my first Android app";
            // otvaranje aktivnosti--implicitni INTENTT
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, messageForFriend);
            sendIntent.setType("text/plain");

            if (sendIntent.resolveActivity(getPackageManager()) != null){
                startActivity(sendIntent);
            }

        }


    }
}
