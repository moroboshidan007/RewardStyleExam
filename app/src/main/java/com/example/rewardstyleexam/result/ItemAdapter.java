package com.example.rewardstyleexam.result;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Adapter to arrange the items.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class ItemAdapter extends BaseAdapter {

    private int mResourceId;
    private LayoutInflater mInflater;

    public ItemAdapter(LayoutInflater inflater, int resourceId) {
        mInflater = inflater;
        mResourceId = resourceId;
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
