package com.example.sugiyama.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private int quantity = 0;
    private ArrayList<QuantityInfo> list = new ArrayList<>();
    private QuantityInfoAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    // 数値の初期値、0を表示
    private void initView() {
        // Textview(palette)、textView(変数)
        TextView textView = (TextView) findViewById(R.id.textview_quantity);
        textView.setText("" + quantity);

        //Button(palette)、plus_button(変数)
        final Button plus_button = (Button) findViewById(R.id.button_plus);
        plus_button.setOnClickListener(this);

        final Button minus_button = (Button) findViewById(R.id.button_minus);
        minus_button.setOnClickListener(this);

        final Button button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(this);

        ListView quantityInfoListView = (ListView) findViewById(R.id.listview_quantity_info);
        adapter = new QuantityInfoAdapter(MainActivity.this);
        adapter.setQuantityInfoList(list);
        quantityInfoListView.setAdapter(adapter);

    }

    // プラス/マイナスボタンを押した時
    public void onClick(View view) {
        // プラスボタンが押下された場合
        // 加算される数は1になり、上限値が5になる
        int validatedValue = 5;
        int addValue = 1;
        switch (view.getId()) {
            case R.id.button_plus:
                break;
            case R.id.button_minus:
                // マイナスボタンが押下された場合
                // 加算される数は-1になり、下限値が0になる
                validatedValue = 0;
                addValue = -1;
                break;
            case R.id.button_add:
                // 追加ボタンを押下された場合
                // 時刻を取得する
                TextView textView = (TextView) findViewById(R.id.label_time);
                String time = textView.getText().toString();
                // コメントを取得する
                EditText edittext = (EditText) findViewById(R.id.edit_comment);
                String comment = edittext.getText().toString();

                QuantityInfo quantityInfo = new QuantityInfo();
                quantityInfo.setTime(time);
                quantityInfo.setComment(comment);
                quantityInfo.setQuantity(quantity);
                list.add(quantityInfo);
                adapter.notifyDataSetChanged();

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
            Toast.makeText(MainActivity.this, R.string.toast_validated_quantity_ng, Toast.LENGTH_SHORT).show();
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

