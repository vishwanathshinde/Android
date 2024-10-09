package com.example.practice_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "EmployeeDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE employee(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, dept TEXT, salary TEXT)";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS employee");
        onCreate(db);
    }

    public boolean registerEmployee(String name, String dept, String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("dept",dept);
        contentValues.put("salary",salary);

        long result = db.insert("employee",null,contentValues);
        return result != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM employee", null);
    }

    public boolean updateEmployee(String name, String dept, String salary) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("dept", dept);
        contentValues.put("salary", salary);

        // Update the record and return true if at least one row was updated
        return db.update("employee", contentValues, "name = ?", new String[]{name}) > 0;
    }

    public boolean deleteEmployee(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("employee", "name = ?", new String[]{name}) > 0;
    }
}