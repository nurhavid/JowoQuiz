package com.example.ajou.jowoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Rank extends AppCompatActivity {
    String email;
    String pass;
    DataBaseHelper dbh;
    ArrayList<Ranking> listRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        Intent intent = getIntent();

        dbh= new DataBaseHelper(this);
        listRanking=dbh.getRanking();

        if (intent != null) {
            email = intent.getStringExtra("Send_mail");
            pass = intent.getStringExtra("Send_pass");
        }

        if(listRanking.size()>0){
            TextView tv=(TextView) findViewById(R.id.Id1);
            tv.setText(listRanking.get(0).username);
            TextView tv2=(TextView) findViewById(R.id.S1);
            tv2.setText(""+listRanking.get(0).score);
        }else{
            TableRow tr=(TableRow) findViewById(R.id.Row1);
            ((ViewGroup) tr.getParent()).removeView(tr);
        }

        if(listRanking.size()>1){
            TextView tv=(TextView) findViewById(R.id.Id2);
            tv.setText(listRanking.get(0).username);
            TextView tv2=(TextView) findViewById(R.id.S2);
            tv2.setText(""+listRanking.get(0).score);
        }else{
            TableRow tr=(TableRow) findViewById(R.id.Row2);
            ((ViewGroup) tr.getParent()).removeView(tr);
        }
        if(listRanking.size()>2){
            TextView tv=(TextView) findViewById(R.id.Id3);
            tv.setText(listRanking.get(0).username);
            TextView tv2=(TextView) findViewById(R.id.S3);
            tv2.setText(""+listRanking.get(0).score);
        }else{
            TableRow tr=(TableRow) findViewById(R.id.Row3);
            ((ViewGroup) tr.getParent()).removeView(tr);
        }
        if(listRanking.size()>3){
            TextView tv=(TextView) findViewById(R.id.Id4);
            tv.setText(listRanking.get(0).username);
            TextView tv2=(TextView) findViewById(R.id.S4);
            tv2.setText(""+listRanking.get(0).score);
        }else{
            TableRow tr=(TableRow) findViewById(R.id.Row4);
            ((ViewGroup) tr.getParent()).removeView(tr);
        }
//        Button back = (Button) findViewById(R.id.log_out);
//        back.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
//                myIntent.putExtra("Send_mail", email);
//                myIntent.putExtra("Send_pass", pass);
//            }
//
//        });
    }
}
