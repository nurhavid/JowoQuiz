package com.example.ajou.jowoquiz;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
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
    int count=0;
    int score=0;
    DataBaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);
        Intent intent = getIntent();
        dbh=new DataBaseHelper(this);

        if (intent != null) {
            email = intent.getStringExtra("Send_mail");
            pass = intent.getStringExtra("Send_pass");
            row = intent.getIntExtra("Send_row",100);
            col = intent.getIntExtra("Send_col",100);

        }
      listQuestion=new ArrayList<Question>();
        if ((row+col)%2==0){
            listQuestion.add(new Question((row+col)%2, "kenthang", "potato",1));
            listQuestion.add(new Question((row+col)%2, "tomat", "tomato",2));
            listQuestion.add(new Question((row+col)%2, "brambang", "onion",3));
            listQuestion.add(new Question((row+col)%2, "wortel", "carrot",4));
            listQuestion.add(new Question((row+col)%2, "woh", "fruit",5));
            listQuestion.add(new Question((row+col)%2, "apel", "apple",6));
            listQuestion.add(new Question((row+col)%2, "gedhang", "banana",7));
            listQuestion.add(new Question((row+col)%2, "jeruk", "orange",8));
            listQuestion.add(new Question((row+col)%2, "susu", "milk",9));
            listQuestion.add(new Question((row+col)%2, "kopi", "coffee",10));
        }else{
            listQuestion.add(new Question((row+col)%2, "wong lanang", "man",1));
            listQuestion.add(new Question((row+col)%2, "wong wadon", "woman",2));
            listQuestion.add(new Question((row+col)%2, "bojo lanang", "husband",3));
            listQuestion.add(new Question((row+col)%2, "bojo wadon", "wife",4));
            listQuestion.add(new Question((row+col)%2, "anak lanang", "boy",5));
            listQuestion.add(new Question((row+col)%2, "anak wadon", "girl",6));
            listQuestion.add(new Question((row+col)%2, "bapak", "father",7));
            listQuestion.add(new Question((row+col)%2, "ibu", "mother",8));
            listQuestion.add(new Question((row+col)%2, "sedulur lanang", "brother",9));
            listQuestion.add(new Question((row+col)%2, "sedulur wadon", "sister",10));
        }
//
        TextView newView = (TextView) findViewById(R.id.Quiz);
        newView.setText(listQuestion.get(count).question);

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