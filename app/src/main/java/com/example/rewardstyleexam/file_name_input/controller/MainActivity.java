package com.example.rewardstyleexam.file_name_input.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.rewardstyleexam.R;
import com.example.rewardstyleexam.file_name_input.view.MainView;
import com.example.rewardstyleexam.file_name_input.view.MainViewListener;

/**
 * Main Activity for user to put in the JSON file name.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class MainActivity extends AppCompatActivity implements MainViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainView mainView = new MainView(LayoutInflater.from(this), null, this, this);
        setContentView(mainView.getRootView());
    }

    @Override
    public void parseFile(String fileName) {
        
    }
}
