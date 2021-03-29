package com.example.rewardstyleexam.result.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rewardstyleexam.R;

public class ResultView {

    private ResultViewListener mListener;
    private View mRootView;

    public ResultView(LayoutInflater inflater, ViewGroup group, ResultViewListener listener) {
        mRootView = inflater.inflate(R.layout.activity_result, group, false);
        mListener = listener;

        Button back = mRootView.findViewById(R.id.bt_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.exitResult();
            }
        });
    }

    public View getRootView() {
        return mRootView;
    }
}
