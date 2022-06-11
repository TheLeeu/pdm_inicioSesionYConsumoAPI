package com.example.pdm_iniciodesesionyconsumoweb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pdm_iniciodesesionyconsumoweb.modelo.Phone;

import java.util.ArrayList;

public class adaptadorPhone extends BaseAdapter {
    public ArrayList<Phone> data;
    private Context context;

    public adaptadorPhone(ArrayList<Phone> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Phone p = (Phone) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.items_phone,null);

        TextView brand = (TextView) view.findViewById(R.id.textView);
        TextView name = (TextView) view.findViewById(R.id.textView2);
        TextView slug = (TextView) view.findViewById(R.id.textView3);

        brand.setText("Brand: "+p.brand);
        name.setText("NamePhone: "+p.phoneName);
        slug.setText("Slug: "+p.slug);
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(context).load(p.image).into(img);


        return view;

    }
}
