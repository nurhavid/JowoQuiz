package com.example.ajou.jowoquiz;

/**
 * Created by ajou on 14/07/2016.
 */
public class History {
    int timestamp;
    String playerUsername;
    int score;
    int categoryId;

    public History(int timestamp, String playerUsername, int score, int categoryId) {
        this.timestamp = timestamp;
        this.playerUsername = playerUsername;
        this.score = score;
        this.categoryId = categoryId;
    }
}
