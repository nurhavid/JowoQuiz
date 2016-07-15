package com.example.ajou.jowoquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by ajou on 7/14/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Game.db";
    public static final String TABLE_1_NAME = "LEVEL";
    public static final String COL_1_1 = "Number";
    public static final String COL_1_2 = "Experience";

    public static final String TABLE_2_NAME = "PLAYER";
    public static final String COL_2_1 = "Username";
    public static final String COL_2_2 = "Password";
    public static final String COL_2_3 = "Gender";
    public static final String COL_2_4 = "Experience";
    public static final String COL_2_5 = "Level_Number";

    public static final String TABLE_3_NAME = "CATEGORY";
    public static final String COL_3_1 = "Id";
    public static final String COL_3_2 = "Name";
    public static final String COL_3_3 = "Icon_Name";
    public static final String COL_3_4 = "Level_Number";

    public static final String TABLE_4_NAME = "HISTORY";
    public static final String COL_4_1 = "Timestamp";
    public static final String COL_4_2 = "Player_Username";
    public static final String COL_4_3 = "Score";
    public static final String COL_4_4 = "Category_Id";

    public static final String TABLE_5_NAME = "QUESTION";
    public static final String COL_5_1 = "Id";
    public static final String COL_5_2 = "Question";
    public static final String COL_5_3 = "Answer";
    public static final String COL_5_4 = "Category_Id";





    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_1_NAME+ " ("
                + COL_1_1 + " INTEGER PRIMARY KEY, "
                + COL_1_2 + " INTEGER NOT NULL);");
        db.execSQL("CREATE TABLE " + TABLE_2_NAME+ " ("
                + COL_2_1 + " TEXT PRIMARY KEY, "
                + COL_2_2 + " TEXT NOT NULL, "
                + COL_2_3 + " TEXT NOT NULL, "
                + COL_2_4 + " INTEGER DEFAULT 0, "
                + COL_2_5 + " INTEGER DEFAULT 1);");
        db.execSQL("CREATE TABLE " + TABLE_3_NAME+ " ("
                + COL_3_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_3_2 + " TEXT NOT NULL, "
                + COL_3_3 + " TEXT, "
                + COL_3_4 + " INTEGER);");
        db.execSQL("CREATE TABLE " + TABLE_4_NAME+ " ("
                + COL_4_1 + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + COL_4_2 + " TEXT NOT NULL, "
                + COL_4_3 + " INTEGER NOT NULL, "
                + COL_4_4 + " INTEGER NOT NULL, PRIMARY KEY ("
                + COL_4_1 +", "+ COL_4_2+"));");
        db.execSQL("CREATE TABLE " + TABLE_5_NAME+ " ("
                + COL_5_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_5_2 + " TEXT NOT NULL, "
                + COL_5_3 + " TEXT NOT NULL, "
                + COL_5_4 + " INTEGER NOT NULL);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_2_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_3_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_4_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_5_NAME);
        onCreate(db);
    }

    public boolean insertDataLevel(int level, int exp){
        SQLiteDatabase db = this. getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1_1,level);
        contentValues.put(COL_1_2,exp);
        long result = db.insert(TABLE_1_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataPlayer(String username, String password, String gender, int exp, int level){
        SQLiteDatabase db = this. getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2_1,username);
        contentValues.put(COL_2_2,password);
        contentValues.put(COL_2_3,gender);
        contentValues.put(COL_2_4,exp);
        contentValues.put(COL_2_5,level);
        long result = db.insert(TABLE_2_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataCategory(int id, String name, String iconName, int level){
        SQLiteDatabase db = this. getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_3_1,id);
        contentValues.put(COL_3_2,name);
        contentValues.put(COL_3_3,iconName);
        contentValues.put(COL_3_4,level);
        long result = db.insert(TABLE_3_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataHistory(String playerUsername, int score, int categoryId){
        SQLiteDatabase db = this. getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_4_2,playerUsername);
        contentValues.put(COL_4_3,score);
        contentValues.put(COL_4_4,categoryId);
        long result = db.insert(TABLE_4_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean insertDataQuestion(int id, String question, String answer, int categoryId){
        SQLiteDatabase db = this. getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_5_1,id);
        contentValues.put(COL_5_2,question);
        contentValues.put(COL_5_3,answer);
        contentValues.put(COL_5_4,categoryId);
        long result = db.insert(TABLE_5_NAME,null,contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getDataLevel(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_1_NAME, null);
        return cursor;
    }

    public Cursor getDataPlayer(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_2_NAME, null);
        return cursor;
    }

    public Cursor getDataCategory(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_3_NAME, null);
        return cursor;
    }
    public Cursor getDataHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_4_NAME, null);
        return cursor;
    }

    public ArrayList<Ranking> getRanking(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select "+COL_4_2+" ,SUM ("+COL_4_3+") as scr from "+TABLE_4_NAME+" group by "+COL_4_2+ " ORDER BY scr", null);
        ArrayList<Ranking> result= new ArrayList<Ranking>();
        if (cursor.moveToFirst()){
            do{
                Ranking ranking=new Ranking(cursor.getString(0), Integer.parseInt(cursor.getString(1)));
                result.add(ranking);
            }while(cursor.moveToNext());
        }
        return result;
    }

    public Cursor getDataQuestion(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_5_NAME, null);
        return cursor;
    }
}
