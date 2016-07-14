package com.example.ajou.jowoquiz;

/**
 * Created by ajou on 7/14/2016.
 */
public class Question {
    public int id;
    public String question;
    public String answer;
    public int categoryId;



    public Question(int categoryId,  String question, String answer,int id) {
        this.categoryId = categoryId;
        this.answer = answer;
        this.question = question;
        this.id = id;
    }

    public Boolean isCorrect(String compare){
        return compare.equalsIgnoreCase(this.answer);
    }
}
