package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String db_name = "employee.DB";
    public static final String tb_name = "Employee_TB";
    public static final String col1 = "ID";
    public static final String col2 = "NAME";
    public static final String col3 = "ADDRESS";


    public DatabaseHelper(Context context) {
        super(context, db_name, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + tb_name + "(ID INTEGER PRIMARY KEY ,NAME TEXT,ADDRESS TEXT)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(("DROP TABLE IF EXISTS " + tb_name));
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(int id,String name, String address) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1,id);
        cv.put(col2, name);
        cv.put(col3, address);

        long res = db.insert(tb_name, null, cv);
        if (res == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + tb_name, null);
        return res;

    }

    public Cursor getRecordByID(Editable record_id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + tb_name + "Where ID=" + record_id, null);
        return res;
    }

    public boolean deleteRecord(String record_id) {
        SQLiteDatabase db = getWritableDatabase();
        Integer res = db.delete(tb_name, "ID=?", new String[]{record_id});

        if (res > 0)
            return true;
        else
            return false;
    }


    public boolean updateData(String id,String name,String address) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col1,id);
        cv.put(col2,name);
        cv.put(col3,address);
        db.update(tb_name,cv,"ID=?",new String[]{id});
        return true;
    }


}
