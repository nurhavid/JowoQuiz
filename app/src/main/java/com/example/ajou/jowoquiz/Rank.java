package com.example.ajou.jowoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rank extends AppCompatActivity {
    String email;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        Intent intent = getIntent();

        if (intent != null) {
            email = intent.getStringExtra("Send_mail");
            pass = intent.getStringExtra("Send_pass");
        }

        Button back = (Button) findViewById(R.id.log_out);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                myIntent.putExtra("Send_mail", email);
                myIntent.putExtra("Send_pass", pass);
            }

        });
    }
}
