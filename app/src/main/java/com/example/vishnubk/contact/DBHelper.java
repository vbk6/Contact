package com.example.vishnubk.contact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vishnubk on 6/1/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    DBHelper DBHelper;

    public static final String DATABASE_NAME = "db";
    public static final String CONTACTS_TABLE_NAME = "contact";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";;
    public static final String CONTACTS_COLUMN_PHONE = "phone";
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
        DBHelper=this;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        //DBHelper = this;
        db.execSQL("create table contact (id integer primary key, name text,phone text)");

       // public static DBHelper getInstance() {
            //return DBHelper;
       // }

   }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }


    public Cursor getContactList(){
        SQLiteDatabase db=getReadableDatabase();
        //database.
        return  null;
    }

    public boolean insertContact  (String name, String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        db.insert("contact", null, contentValues);
        return true;
    }
    public  Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact", null );

        return res;
    }


}
