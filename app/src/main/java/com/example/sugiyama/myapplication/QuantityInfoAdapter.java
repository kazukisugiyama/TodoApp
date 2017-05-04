package com.example.sugiyama.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuantityInfoAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater = null;
    ArrayList<QuantityInfo> quantityInfoList;

    public QuantityInfoAdapter(Context context) {
        this.context = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setQuantityInfoList(ArrayList<QuantityInfo> quantityInfoList) {
        this.quantityInfoList = quantityInfoList;
    }

    @Override
    public int getCount() {
        return quantityInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return quantityInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return quantityInfoList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_quantity_info,parent,false);
        }

        ((TextView)convertView.findViewById(R.id.textview_time)).setText(quantityInfoList.get(position).getTime());
        ((TextView)convertView.findViewById(R.id.textview_quantity)).setText("" + quantityInfoList.get(position).getQuantity());
        ((TextView)convertView.findViewById(R.id.textview_comment)).setText(quantityInfoList.get(position).getComment());

        return convertView;
    }
}