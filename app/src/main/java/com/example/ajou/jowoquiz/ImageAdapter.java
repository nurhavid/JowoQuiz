package com.example.ajou.jowoquiz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }

    private Integer[] mThumbsIds = {
            R.drawable.basic1_icon,
            R.drawable.basic2_icon,
            R.drawable.basic3_icon,
            R.drawable.intermediate1_icon,
            R.drawable.intermediate2_icon,
            R.drawable.intermediate3_icon
 //           R.drawable.basic1_icon,
 //           R.drawable.basic2_icon,
 //           R.drawable.basic3_icon,
//            R.drawable.intermediate1_icon,
//            R.drawable.intermediate2_icon,
//            R.drawable.intermediate3_icon
//            R.drawable.basic1_icon,
//            R.drawable.basic2_icon,
//            R.drawable.basic3_icon,
//            R.drawable.food_icon,
//            R.drawable.animal_icon,
//            R.drawable.numbers_icon,
//            R.drawable.intermediate1_icon,
//            R.drawable.intermediate2_icon,
//            R.drawable.intermediate3_icon
    };


    @Override
    public int getCount() {
        return mThumbsIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview;
        if (convertView==null){
            imageview = new ImageView(mContext);
            imageview.setLayoutParams(new GridView.LayoutParams(300,300));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(10,10,10,10);
        }else{
            imageview = (ImageView) convertView;
        }
        imageview.setImageResource(mThumbsIds[position]);
        return imageview;
    }
}
