package com.example.ajou.jowoquiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Ref;
import java.util.ArrayList;

/**
 * Created by ajou on 14/07/2016.
 */

public class QUIZ extends AppCompatActivity {
    HavidDialogFragment New_Allert = new HavidDialogFragment();
    ArrayList<Question> listQuestion;
    String email;
    String pass;
    int row;
    int col;
    int pos;
    int count=0;
    int score=0;
    DataBaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        Intent intent = getIntent();
        dbh=new DataBaseHelper(this);
        dbh.Insert1();
        if (intent != null) {
            email = intent.getStringExtra("Send_mail");
            pass = intent.getStringExtra("Send_pass");
            pos = intent.getIntExtra("Send_pos",100);
            //col = intent.getIntExtra("Send_col",100);

        }
      listQuestion=new ArrayList<Question>();
        if ((pos)==0){
            for(int i=0; i<10;i++){
                listQuestion.add(new Question(0,dbh.getAllQusetion().get(i).getQuestion(),dbh.getAllQusetion().get(i).getAnswer(),i+1));
            }
            TextView newView = (TextView) findViewById(R.id.Quiz);
            newView.setText(listQuestion.get(count).question);
        }else{
            for(int i=0; i<10;i++){
                listQuestion.add(new Question(0,dbh.getAllQusetion().get(i+10).getQuestion(),dbh.getAllQusetion().get(i+10).getAnswer(),i+11));
            }
            TextView newView = (TextView) findViewById(R.id.Quiz);
            newView.setText(listQuestion.get(count).question);

        }
//


    }

    public void Enter(View view){
        EditText answer=(EditText) findViewById(R.id.Edit);
        if(listQuestion.get(count).isCorrect(answer.getText().toString())){
            count++;
            score++;
            Refresh();
            Toast.makeText(this, "Anawer Correct",Toast.LENGTH_SHORT).show();
        }else{
            Refresh();
            Toast.makeText(this, "Anawer Wrong",Toast.LENGTH_SHORT).show();
        }

    }

    public void Skip(View view){
        count++;
        Refresh();

    }

    public void Refresh(){
        if((count)==listQuestion.size()){
            if( dbh.insertDataHistory("ajou@gmail.com",score,(row+col)%2)){
                Log.d("Fahmi", "Berhasil");
            }else{
                Log.d("Fahmi", "Gagal");
            }
            New_Allert.show(getFragmentManager(),"Hello");
        }else{
            TextView newView = (TextView) findViewById(R.id.Quiz);
            newView.setText(listQuestion.get(count).question);

            EditText editText= (EditText) findViewById(R.id.Edit);
            editText.setText("");

            TextView judul=(TextView) findViewById(R.id.Judul);
            judul.setText("Question "+(count+1)+"/10");
        }

    }

    public void Exit(View view){
        finish();
    }
    public void Again(View view){
        New_Allert.dismiss();
        count=0;
        Refresh();
    }


    @SuppressLint("ValidFragment")
    public class HavidDialogFragment extends android.app.DialogFragment {

        Dialog dlg;

        public Dialog onCreateDialog(Bundle savedInstanceState){
            dlg = new Dialog(getActivity());
            dlg.setContentView(R.layout.custom_dialog);
            TextView text = (TextView) dlg.findViewById(R.id.Score);
            text.setText(""+score);
            return dlg;

        }

    }


}