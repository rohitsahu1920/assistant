package com.example.rohit.assistent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rohit on 07-Feb-18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table teacher (email text primary key,password text)");
        db.execSQL("create table principal (email text primary key,password text)");
        db.execSQL("create table parents (email text primary key,password text)");
        db.execSQL("create table student (email text primary key,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists teacher");
        db.execSQL("drop table if exists principal");
        db.execSQL("drop table if exists parents");
        db.execSQL("drop table if exists student");
    }

  //teachers

    public boolean insertteacher(String email,String password){
        SQLiteDatabase dbteacher = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = dbteacher.insert("teacher",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public Boolean chkemailteacher(String email){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("Select * from teacher where email=?",new String[]{email});
        if(cursor.getCount() > 0)return false;
        else return true;
    }

    public Boolean emailpassteacher(String email,String pass){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("select * from teacher where email=? AND password=?",new String[]{email,pass});
        if(cursor.getCount() >0) return true;
        else return false;
    }

    //principal
    public boolean insertprincipal(String email,String password){
        SQLiteDatabase dbteacher = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = dbteacher.insert("principal",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public Boolean chkemailprincilap(String email){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("Select * from principal where email=?",new String[]{email});
        if(cursor.getCount() > 0)return false;
        else return true;
    }

    public Boolean emailpassprincipal(String email,String pass){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("select * from principal where email=? AND password=?",new String[]{email,pass});
        if(cursor.getCount() >0) return true;
        else return false;
    }

    //parents
    public boolean insertparents(String email,String password){
        SQLiteDatabase dbteacher = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = dbteacher.insert("parents",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public Boolean chkemailparents(String email){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("Select * from parents where email=?",new String[]{email});
        if(cursor.getCount() > 0)return false;
        else return true;
    }

    public Boolean emailpassparents(String email,String pass){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("select * from parents where email=? AND password=?",new String[]{email,pass});
        if(cursor.getCount() >0) return true;
        else return false;
    }


    //student
    public boolean insertstudent(String email,String password){
        SQLiteDatabase dbteacher = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = dbteacher.insert("student",null,contentValues);
        if(ins == -1) return false;
        else return true;
    }

    public Boolean chkemailstudent(String email){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("Select * from student where email=?",new String[]{email});
        if(cursor.getCount() > 0)return false;
        else return true;
    }

    public Boolean emailpassstudent(String email,String pass){
        SQLiteDatabase dbteacher = this.getReadableDatabase();
        Cursor cursor = dbteacher.rawQuery("select * from student where email=? AND password=?",new String[]{email,pass});
        if(cursor.getCount() >0) return true;
        else return false;
    }

}
