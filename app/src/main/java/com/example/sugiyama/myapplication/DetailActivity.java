package com.example.sugiyama.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("");

        Intent intent = getIntent();
        //MainActivityから値を受け取る
        QuantityInfo info = (QuantityInfo)getIntent().getSerializableExtra("QuantityInfo" );

        //id textView1をt1に当てはめている
        TextView time = (TextView)findViewById(R.id.textView1);
//        //id textView1をt2に当てはめている
        TextView comment = (TextView)findViewById(R.id.textView2);
        //id textView1をt3に当てはめている
        TextView quantity = (TextView)findViewById(R.id.textView3);

        //受け取った値を表示
        time.setText(info.getTime());
        comment.setText(info.getComment());
        quantity.setText("" + info.getQuantity());
    }
}