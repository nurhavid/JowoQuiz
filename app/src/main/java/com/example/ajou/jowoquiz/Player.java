package com.example.ajou.jowoquiz;

/**
 * Created by ajou on 7/14/2016.
 */

public class Player {
    String username;
    String password;
    String gender;
    int exp;
    int level;

    public Player(String username, String password, String gender, int exp, int level) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.exp = exp;
        this.level = level;
    }
}
