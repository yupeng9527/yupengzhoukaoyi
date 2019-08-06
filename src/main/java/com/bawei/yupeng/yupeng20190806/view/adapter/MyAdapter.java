package com.bawei.yupeng.yupeng20190806.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yupeng.yupeng20190806.R;
import com.bawei.yupeng.yupeng20190806.model.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private List<Bean> list;
    private Context context;

    public MyAdapter(List<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder holder;
        ViewHolder1 holder1;
        switch (getItemViewType(position)){
            case 0:
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.item,null);
                    holder = new ViewHolder();
                    holder.tv = convertView.findViewById(R.id.tv);
                    holder.iv = convertView.findViewById(R.id.iv);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.tv.setText(list.get(position).getContent());
                Glide.with(context).load(list.get(position).getAvatar()).into(holder.iv);
                break;
            case 1:
                if (convertView == null){
                    convertView = View.inflate(context, R.layout.item1,null);
                    holder1 = new ViewHolder1();
                    holder1.tv1 = convertView.findViewById(R.id.tv1);
                    holder1.iv1 = convertView.findViewById(R.id.iv1);
                    convertView.setTag(holder1);
                }else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                holder1.tv1.setText(list.get(position).getContent());
                Glide.with(context).load(list.get(position).getAvatar()).into(holder1.iv1);
                break;
        }
        return convertView;
    }
    class ViewHolder{
        TextView tv;
        ImageView iv;
    }
    class ViewHolder1{
        TextView tv1;
        ImageView iv1;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
