package com.crissiiu.sqliteex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HowKSQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_PEOPLE = "people";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PERSON = "person";

    private static final String DATABASE_NAME = "people.db";
    private static final int DATABASE_VERSION = 1;

    //Cau lenh khoi tao db
    private static final String DATABASE_CREATE = "create table "
            + TABLE_PEOPLE +"( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_PERSON
            +" text not null);";

    public HowKSQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Tao co so du lieu
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        Log.v(HowKSQLiteHelper.class.getName(),
                "Upgrading database from version " + i + " to "
                + i1 + ", which will destroy all old data"
        );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PEOPLE);
        onCreate(sqLiteDatabase);
    }
}
