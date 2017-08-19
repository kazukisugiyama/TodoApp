package com.example.sugiyama.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by sugiyama on 2017/07/08.
 */

public class DBHelper extends SQLiteOpenHelper {
    // データベース名
    public static final String DB_NAME_INFO = "info";
    // テーブル名
    public static final String DB_TABLE_APPLICATION_INFO = "applicationInfo";
    // カラム名
    public static final String DB_COLUMN_ID = "id";
    public static final String DB_COLUMN_QUANTITY = "quantity";
    public static final String DB_CULUMN_COMMENT = "comment";
    public static final String DB_CULUMN_TIME = "time";
    public static final String DB_IMAGE = "image";

    public DBHelper(Context context) {
        super(context, "quantityinfo.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブルの作成
        String sql = "create table "
                + DB_TABLE_APPLICATION_INFO + "("
                + DB_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DB_COLUMN_QUANTITY + " INTEGER, "
                + DB_CULUMN_COMMENT + " TEXT, "
                + DB_CULUMN_TIME + " INTEGER, "
                + DB_IMAGE + " BLOB "
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}