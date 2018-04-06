package com.haunguyen.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

/**
 * Created by Hau Nguyen on 02-Apr-18.
 */

public class MyArrayAdapter extends BaseAdapter {
    Context context;
    ArrayList<ThongTinThuChi> thongtinthuchi=null;
    int layoutId;

    public MyArrayAdapter(Context context, int layoutId, ArrayList<ThongTinThuChi> arr){

        this.context = context;
        this.layoutId = layoutId;
        this.thongtinthuchi = arr;
    }


    @Override
    public int getCount() {
        return thongtinthuchi.size();
    }

    @Override
    public Object getItem(int i) {
        return thongtinthuchi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutId, null);

            viewHolder.txt = convertView.findViewById(R.id.tvItem);
            viewHolder.imageView = convertView.findViewById(R.id.imgItem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ThongTinThuChi thongTinThuChi = (ThongTinThuChi) getItem(position);
        if (thongTinThuChi.isHinhthuc() == false){
            viewHolder.imageView.setImageResource(R.drawable.chi);
        }
        else {
            viewHolder.imageView.setImageResource(R.drawable.thu);
        }
        viewHolder.txt.setText(thongTinThuChi.toString());
        return convertView;
    }
    class ViewHolder {
        TextView txt;
        ImageView imageView;
    }
}