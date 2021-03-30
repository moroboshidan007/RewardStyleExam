package com.example.rewardstyleexam.result.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.rewardstyleexam.R;
import com.example.rewardstyleexam.result.ItemAdapter;
import com.example.rewardstyleexam.util.HiringItem;

import java.util.ArrayList;

public class ResultView {

    private ItemAdapter mAdapter;
    private LayoutInflater mInflater;
    private ResultViewListener mListener;
    private View mRootView;

    private ListView itemsList;

    public ResultView(LayoutInflater inflater, ViewGroup group, ResultViewListener listener) {
        mRootView = inflater.inflate(R.layout.activity_result, group, false);
        mListener = listener;
        mInflater = inflater;

        Button back = mRootView.findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.exitResult();
            }
        });
        itemsList = mRootView.findViewById(R.id.lv_id);
        mAdapter = new ItemAdapter(mInflater, R.layout.view_list_item);
        itemsList.setAdapter(mAdapter);
    }

    public void updateItems(ArrayList<HiringItem> list) {
        mAdapter.updateHiringList(list);
    }

    public View getRootView() {
        return mRootView;
    }
}
