package com.example.ajou.jowoquiz;

/**
 * Created by ajou on 14/07/2016.
 */
public class Category {
    int id;
    String name;
    String iconName;
    int level;

    public Category(String name, String iconName, int level) {
        this.name = name;
        this.iconName = iconName;
        this.level = level;
    }
}
