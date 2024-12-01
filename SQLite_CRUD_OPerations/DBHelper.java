package com.example.practice_app;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context){
        super(context, "ConferenceDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE student (id INTEGER PRIMARY KEY, name TEXT, topic TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int ov, int nv){
    }

    public boolean insertStudent(String id, String name, String topic){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id",id);
        cv.put("name", name);
        cv.put("topic", topic);

        long result = db.insert("student", null, cv);
        return result != -1;
    }

    public Cursor displayData(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM student", null);
    }

    public boolean updateStudent(String id, String name, String topic){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("id",id);
        cv.put("name",name);
        cv.put("topic",topic);

        return db.update("student", cv, "id = ?", new String[]{id})>0;
    }

    public boolean deleteStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("student", "id = ?" , new String[]{id})>0;
    }
}
