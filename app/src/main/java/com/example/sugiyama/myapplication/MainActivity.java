package com.example.sugiyama.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    // 数値の初期値、0を表示
    private void initView() {
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        textView.setText("" + quantity);

        final Button plus_button = (Button) findViewById(R.id.plus_button);
        plus_button.setOnClickListener(this);

        final Button minus_button = (Button) findViewById(R.id.minus_button);
        minus_button.setOnClickListener(this);
    }

    // プラス/マイナスボタンを押した時
    public void onClick(View view) {
        // プラスボタンが押下された場合
        // 加算される数は1になり、上限値が5になる
        int validatedValue = 5;
        int addValue = 1;
        switch (view.getId()) {
            case R.id.plus_button:
                break;
            case R.id.minus_button:
                // マイナスボタンが押下された場合
                // 加算される数は-1になり、下限値が0になる
                validatedValue = 0;
                addValue = -1;
                break;
            default:
                return;
        }

        // 数量が上限値または下限値に達していない場合
        if (validatedQuantity(validatedValue)) {
            // 数量を加算する
            addQuantity(addValue);
        } else {
            // 達している場合
            // メッセージを表示、加算しない
            Toast.makeText(MainActivity.this, "入力できません。", Toast.LENGTH_SHORT).show();
        }
    }

    // 数量が引数と同じでない場合、true
    private boolean validatedQuantity(int value) {
        // 数量と引数と同じ場合、false
        if (quantity == value) {
            return false;
        }

        return true;
    }


    // 数量を引数分加算し、結果を表示する
    private void addQuantity(int value) {
        // 引数を加算する
        quantity += value;
        // 計算結果を画面に表示する
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        textView.setText("" + quantity);
    }


}
