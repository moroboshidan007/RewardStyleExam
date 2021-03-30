package com.example.rewardstyleexam.result;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rewardstyleexam.R;
import com.example.rewardstyleexam.util.HiringItem;

import java.util.ArrayList;

/**
 * Adapter to arrange the items.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class ItemAdapter extends BaseAdapter {

    private ArrayList<HiringItem> mList;
    private int mResourceId;
    private LayoutInflater mInflater;

    public ItemAdapter(LayoutInflater inflater, int resourceId) {
        mInflater = inflater;
        mResourceId = resourceId;
        mList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(mResourceId, null);
        }
        TextView id = convertView.findViewById(R.id.tv_id);
        TextView listId = convertView.findViewById(R.id.tv_list_id);
        TextView name = convertView.findViewById(R.id.tv_name);
        id.setText(String.valueOf(mList.get(position).getId()));
        listId.setText(String.valueOf(mList.get(position).getListId()));
        name.setText(mList.get(position).getName());
        return convertView;
    }

    public void updateHiringList(ArrayList<HiringItem> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }
}
