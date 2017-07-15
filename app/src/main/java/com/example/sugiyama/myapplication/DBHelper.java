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
    public static final String DB_NAME_INFO = "Info";
    // テーブル名
    public static final String DB_TABLE_APPLICATION_INFO = "ApplicationInfo";
    // カラム名
    public static final String DB_COLUMN_ID = "id";
    public static final String DB_COLUMN_QUANTITY = "Quantity";
    public static final String DB_CULUMN_COMMENT = "Comment";
    public static final String DB_CULUMN_TIME = "Time";
    public static final String DB_CULUM_SELECTED = "Selected";
    public static final String DB_IMAGE = "image";
    // データベースバージョン a
    public static final int DB_VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブルの作成
        String sql = "create table DB_TABLE_APPLICATION_INFO(DB_COLUMN_QUANTITY," +
                "DB_CULUMN_COMMENT" + "DB_CULUMN_TIME" + "DB_CULUM_SELECTED" + "DB_IMAGE)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "SELECT * FROM DB_TABLE_APPLICATION_INFO";
        // テーブル内にカラムが含まれていなかった場合
        if (sql == null) {
            sql = "DB_TABLE_APPLICATION_INFO(DB_COLUMN_QUANTITY," +
                    "DB_CULUMN_COMMENT" + "DB_CULUMN_TIME" + "DB_CULUM_SELECTED" + "DB_IMAGE)";
        }
    }
}