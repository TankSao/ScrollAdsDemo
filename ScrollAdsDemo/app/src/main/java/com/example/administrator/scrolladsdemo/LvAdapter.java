package com.example.administrator.scrolladsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */

public class LvAdapter extends BaseAdapter{
    private List<String> mList;
    private Context mContext;
    private ViewHolder holder;

    public LvAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position % mList.size());
    }

    @Override
    public long getItemId(int position) {
        return position % mList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        position = position%mList.size();
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.item_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(mList.get(position));
        return convertView;
    }


    class ViewHolder {
        TextView tv;
    }
}
