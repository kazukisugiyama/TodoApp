package com.example.sugiyama.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;

public class DetailActivity extends AppCompatActivity  {

    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView imageView;
    private int mImageType = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("");
        imageView = (ImageView)findViewById(R.id.image_View);

        Intent intent = getIntent();
        //MainActivityから値を受け取る
        QuantityInfo info = (QuantityInfo) getIntent().getSerializableExtra("QuantityInfo");

        //id textView1をt1に当てはめている
        TextView time = (TextView) findViewById(R.id.textView1);
        //id textView1をt2に当てはめている
        TextView comment = (TextView) findViewById(R.id.textView2);
        //id textView1をt3に当てはめている
        TextView quantity = (TextView) findViewById(R.id.textView3);

        //受け取った値を表示
        time.setText(info.getTime());
        comment.setText(info.getComment());
        quantity.setText("" + info.getQuantity());


        // 画像表示ボタン押下後の処理
        findViewById(R.id.button_activity_detail_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });
    }


    // 画像選択、取得
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
            if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == RESULT_OK) {
                Uri uri = null;
                if (resultData != null) {
                    uri = resultData.getData();

                    try {
                        Bitmap bmp = getBitmapFromUri(uri);
                        imageView.setImageBitmap(bmp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    // 画像表示
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

    // 画像を保持させる







    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, mImageType);
    }


    // 画像削除ボタン押下後の処理

}
