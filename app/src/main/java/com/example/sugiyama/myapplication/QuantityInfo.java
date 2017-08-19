package com.example.sugiyama.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class QuantityInfo implements Serializable {

    public int quantity;
    private String time;
    private String comment;
    private boolean isSelected;
    private int id;
    private Bitmap bitmap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {this.time = time;}


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {this.comment = comment;}

}


