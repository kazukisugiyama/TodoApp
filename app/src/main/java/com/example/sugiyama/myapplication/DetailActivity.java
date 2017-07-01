package com.example.sugiyama.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private static final int RESULT_BACK = 9999;
    private ImageView imageView;
    private int mImageType = 0;
    private ArrayList<QuantityInfo> infoList = new ArrayList<>();
    private ArrayList<AppBean> list = new ArrayList<>();
    private static final String INTENT_KEY_QUANTITY_INFO_ROW = "intent_key_row";
    private QuantityInfo info ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
    }

    private void initView() {
        setTitle("");
        imageView = (ImageView) findViewById(R.id.image_view);

        // 画像選択ボタン
        final Button selectButton = (Button) findViewById(R.id.button_activity_detail_select);
        selectButton.setOnClickListener(this);

        // 戻るボタン
        final Button retrunButton = (Button) findViewById(R.id.button_returun);
        retrunButton.setOnClickListener(this);

        // MainActivityから値を受け取る
        int row = getIntent().getIntExtra(INTENT_KEY_QUANTITY_INFO_ROW,0);
        info = getInfoList().get(row);
        imageView.setImageBitmap(info.bitmap);

        // id textView1をt1に当てはめている
        TextView time = (TextView) findViewById(R.id.textView1);
        // id textView1をt2に当てはめている
        TextView comment = (TextView) findViewById(R.id.textView2);
        // id textView1をt3に当てはめている
        TextView quantity = (TextView) findViewById(R.id.textView3);

        //受け取った値を表示
        time.setText(info.getTime());
        comment.setText(info.getComment());
        quantity.setText("" + info.getQuantity());
    }


    // ボタンを押下後の処理
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_activity_detail_select:
                selectButton();
                return;
            case R.id.button_returun:
                retrunButton();
                return;
            default:
        }
    }


    // 画像表示ボタン押下後の処理
    public void selectButton() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
    }


    // 画像選択、取得
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == RESULT_OK) {
            if (resultData != null) {
                Uri uri = resultData.getData();
                imageView.setImageURI(uri);
                Bitmap bitmap = getBitmapFromUri(uri);
                info.bitmap = bitmap;
            }
        }
    }

    // 画像表示
    private Bitmap getBitmapFromUri(Uri uri) {
        try {
            return MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
        } catch (IOException e) {
            return null;
        }
    }

    // 戻るボタン押下時の処理
    public void retrunButton() {
        finish();
    }

    // AppBeanから情報取得
    private ArrayList<QuantityInfo> getInfoList(){
        AppBean appBean = (AppBean) getApplication();
        return appBean.list;
    }

    // Intentの生成
    public static Intent getNewIntent(Activity activity, int row) {

        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(INTENT_KEY_QUANTITY_INFO_ROW, row);

        return intent;
    }
}
