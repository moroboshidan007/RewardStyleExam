package com.example.rewardstyleexam.file_name_input.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rewardstyleexam.R;

public class MainView {

    private Context mContext;
    private MainViewListener mListener;
    private View mRootView;

    public MainView(LayoutInflater inflater, ViewGroup group, Context context, MainViewListener listener) {
        mRootView = inflater.inflate(R.layout.activity_main, group, false);
        mContext = context;
        mListener = listener;

        final EditText fileNameInput = mRootView.findViewById(R.id.et_file_name);

        Button parse = mRootView.findViewById(R.id.bt_parse);
        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileName = fileNameInput.getText().toString();
                if (fileName.isEmpty()) {
                    Toast.makeText(mContext, R.string.file_name_empty, Toast.LENGTH_SHORT).show();
                } else if (!fileName.endsWith(".json")) {
                    Toast.makeText(mContext, R.string.invalid_file_name, Toast.LENGTH_SHORT).show();
                } else {
                    mListener.parseFile(fileName);
                }
            }
        });
    }

    public View getRootView() {
        return mRootView;
    }
}
