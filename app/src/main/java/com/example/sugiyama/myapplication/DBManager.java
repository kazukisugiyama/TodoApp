package com.example.sugiyama.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import static com.example.sugiyama.myapplication.DBHelper.DB_COLUMN_ID;
import static com.example.sugiyama.myapplication.DBHelper.DB_COLUMN_QUANTITY;
import static com.example.sugiyama.myapplication.DBHelper.DB_CULUMN_COMMENT;
import static com.example.sugiyama.myapplication.DBHelper.DB_CULUMN_TIME;
import static com.example.sugiyama.myapplication.DBHelper.DB_IMAGE;
import static com.example.sugiyama.myapplication.DBHelper.DB_TABLE_APPLICATION_INFO;

/**
 * Created by sugiyama on 2017/08/19.
 */

public class DBManager {

    // 一覧のデータ取得
    public ArrayList<QuantityInfo> getQuantityInfoList(Context context) {
        SQLiteOpenHelper sqliteOpenHelper = new DBHelper(context);
        SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();

        String[] columns = {DB_COLUMN_ID,
                DB_COLUMN_QUANTITY,
                DB_CULUMN_COMMENT,
                DB_CULUMN_TIME,
                DB_IMAGE};
        String orderBy = DB_CULUMN_TIME + " DESC";
        ArrayList<QuantityInfo> infoArrayList = new ArrayList();
        try {
            Cursor cursor = db.query(DB_TABLE_APPLICATION_INFO,
                    columns,
                    null,
                    null,
                    null,
                    null,
                    orderBy);
            while (cursor.moveToNext()) {
                QuantityInfo quantityInfo = new QuantityInfo();
                quantityInfo.setId(cursor.getInt(0));
                quantityInfo.setQuantity(cursor.getInt(1));
                quantityInfo.setComment(cursor.getString(2));
                quantityInfo.setTime(cursor.getString(3));
                byte[] array = cursor.getBlob(4);
                Bitmap bitmap = BitmapFactory.decodeByteArray(array, 0, array.length);
                quantityInfo.setBitmap(bitmap);
                infoArrayList.add(quantityInfo);
            }
        } finally {
            db.close();
        }
        return infoArrayList;

        // データ追加
        // データ参照
        // データ削除
        // データ更新 info list
        public void updateList(){
            ContentValues values = new ContentValues();
            values.put(DB_COLUMN_QUANTITY,1);
            values.put(DB_CULUMN_COMMENT,2);
            values.put(DB_CULUMN_TIME,3);
            values.put(DB_IMAGE,4);
            // 指定した行のみ更新
            String whereArgs[] = ;
            try{
                db.update(DB_TABLE_APPLICATION_INFO, values, "id = ?", )
            }

        }
    }
}



//    public void updateList(){
//        String whereClause = "text_column = ?";
//        String whereArgs[] = new String[1];
//        whereArgs[0] = "text";
//
//        try {
//            db.update("sample_table", values, whereClause, whereArgs);
//        } finally {
//            db.close();
//        }

    }

    // 削除 ID分かればOK

