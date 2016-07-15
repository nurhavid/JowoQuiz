package com.example.ajou.jowoquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 4;
    Button buttons[][]=new Button[NUM_ROWS][NUM_COLS];
    String email;
    String pass;
    DataBaseHelper sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sql=new DataBaseHelper(this);

        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        if (intent != null) {
            email = intent.getStringExtra("Send_mail");
            pass = intent.getStringExtra("Send_pass");
        }

        Button M_rank = (Button) findViewById(R.id.Rank);
        M_rank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),Rank.class);
                myIntent.putExtra("Send_mail", email);
                myIntent.putExtra("Send_pass", pass);
                startActivity(myIntent);
                //finish();
            }

        });

        Button log_out = (Button) findViewById(R.id.log_out);
        log_out.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                finish();
            }

        });

        TextView myTextView= (TextView) findViewById(R.id.text_1);
        myTextView.setText(email);
        TextView myTextView2= (TextView) findViewById(R.id.text_2);
       // myTextView2.setText(pass);

        populateButton();

    }
    private void populateButton(){
        TableLayout table = (TableLayout) findViewById((R.id.tableforbutton));
        for (int row =0;row<NUM_ROWS;row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
                    table.addView(tableRow);
                for(int col=0;col<NUM_COLS;col++){
                    final int FINAL_COL = col;
                    final int FINAL_ROW = row;
                    Button button = new Button (this);
                    button.setLayoutParams(new TableRow.LayoutParams(
                            TableRow.LayoutParams.MATCH_PARENT,
                            TableRow.LayoutParams.MATCH_PARENT,
                            1.0f));
                        //button.setText(""+col+","+row);
                        button.setPadding(0,0,0,0);
                        button.setBackgroundColor(Color.argb(0,255,255,255));

                        button.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                           CallMe(FINAL_COL,FINAL_ROW);
                            Choose(FINAL_COL,FINAL_ROW);
                            //Something();

                    }
                });
                tableRow.addView(button);
                    buttons[row][col]=button;
            }
        }
    }

    private void CallMe(int col,int row){
        Toast.makeText(this,"Buttone Clicked"+col+","+row, Toast.LENGTH_SHORT).show();
    }

    private void Choose(int col,int row){
        //if (col==0&&row == 0){
            Intent myIntent = new Intent(this, QUIZ.class);
            myIntent.putExtra("Send_mail", email);
            myIntent.putExtra("Send_pass", pass);
            myIntent.putExtra("Send_row", row);
            myIntent.putExtra("Send_col", col);
            startActivityForResult(myIntent, 0);
       // }
    }

    private void RankActivity(View v){
        Intent myIntent = new Intent(this, Rank.class);
        myIntent.putExtra("Send_mail", email);
        myIntent.putExtra("Send_pass", pass);
        startActivityForResult(myIntent, 0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        for (int i=0;i<NUM_ROWS;i++){
            for (int j=0; j<NUM_COLS;j++){
                Button button = buttons[i][j];
                lockButtonSizes();
                int newWidth = button.getWidth();
                int newHeight = button.getHeight();
                if(i==0&&j==0){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.basic1_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }
                if(i==0&&j==1){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.basic2_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==0&&j==2){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.basic3_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==0&j==3){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.animal_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                } if(i==1&&j==0){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.intermediate1_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }
                if(i==1&&j==1){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.intermediate2_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==1&&j==2){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.intermediate3_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==1&&j==3){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.food_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }
                if(i==2&&j==0){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.basicgreeting_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }
                if(i==2&&j==1){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.numbers_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==2&&j==2){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.intermediate2_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }if(i==2&&j==3){
                    Bitmap originalBitmap= BitmapFactory.decodeResource(getResources(), R.drawable.intermediate3_icon);
                    Bitmap scaleBitmap = Bitmap.createScaledBitmap(originalBitmap,newWidth,newHeight, true);
                    Resources resource = getResources();
                    button.setBackgroundDrawable(new BitmapDrawable(resource,scaleBitmap));
                }
            }
        }
    }

    private void lockButtonSizes(){
        for(int row =0;row < NUM_ROWS; row++){
            for(int col=0;col<NUM_COLS;col++){
                Button button = buttons[row][col];
                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);
                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);

            }
        }
    }

}
