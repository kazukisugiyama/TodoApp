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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        textView.setText("0");

        final Button plus_button = (Button) findViewById(R.id.plus_button);
        plus_button.setOnClickListener(this);

        final Button minus_button = (Button) findViewById(R.id.minus_button);
        minus_button.setOnClickListener(this);
    }

    public void onClick(View view) {
        int validatedValue = 5;
        int addValue = 1;
        switch (view.getId()){
            case R.id.plus_button:
                break;
            case R.id.minus_button:
                validatedValue = 0;
                addValue = -1;
                break;
            default:
                break;
        }

        if (validatedQuantity(validatedValue)) {
            addQuantity(addValue);
        } else {
            Toast.makeText(MainActivity.this, "入力できません", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatedQuantity(int value) {
        // 画面に表示している値を取得する
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        String text = textView.getText().toString();
        // 文字列を数値に変換する
        int num = Integer.parseInt(text);
        // 画面に表示している数値が引数と同じ場合、false
        if (num == value) {
            return false;
        }

        return true;
    }


    private void addQuantity(int value) {
        // 画面に表示している値を取得する
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        String text = textView.getText().toString();
        // 引数を加算する
        int num = Integer.parseInt(text);
        num = num + value;
        // 計算結果を画面に表示する
        final String displayText = "" + num;
        Log.d("debug", displayText);
        textView.setText(displayText);
    }


}
