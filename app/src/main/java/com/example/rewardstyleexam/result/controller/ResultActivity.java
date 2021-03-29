package com.example.rewardstyleexam.result.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.rewardstyleexam.R;
import com.example.rewardstyleexam.result.view.ResultView;
import com.example.rewardstyleexam.result.view.ResultViewListener;

/**
 * Page to show results.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class ResultActivity extends AppCompatActivity implements ResultViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ResultView resultView = new ResultView(LayoutInflater.from(this), null, this);
        setContentView(resultView.getRootView());
    }

    @Override
    public void exitResult() {
        finish();
    }
}
