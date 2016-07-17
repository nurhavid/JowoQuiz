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

    public Question() {
        this.categoryId = 0;
        this.answer = "";
        this.question = "";
        this.id = 0;
    }

    public Boolean isCorrect(String compare){
        return compare.equalsIgnoreCase(this.answer);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
