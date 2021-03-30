package com.example.rewardstyleexam.result.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.rewardstyleexam.result.model.ResultModel;
import com.example.rewardstyleexam.result.model.ResultModelListener;
import com.example.rewardstyleexam.result.view.ResultView;
import com.example.rewardstyleexam.result.view.ResultViewListener;
import com.example.rewardstyleexam.util.HiringItem;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Page to show results.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class ResultActivity extends AppCompatActivity implements ResultViewListener, ResultModelListener {

    private ResultView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mView = new ResultView(LayoutInflater.from(this), null, this);
        setContentView(mView.getRootView());

        final ResultModel resultModel = new ResultModel(this);

        Intent intent = getIntent();
        assert intent != null;
        final String fileName = intent.getStringExtra("file_name");
        if (fileName != null) {
            // The file name has to be on the server.
            if (!fileName.startsWith("http://") || !fileName.startsWith("https://")) {
                exitResult();
                return;
            }
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Download the file to local
                        URL url = new URL(fileName);
                        URLConnection connection = url.openConnection();
                        int length = connection.getContentLength();
                        DataInputStream dis = new DataInputStream(url.openStream());
                        byte[] dataBuffer = new byte[length];
                        dis.readFully(dataBuffer);
                        dis.close();
                        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(getFilesDir(), "downloaded_file.json")));
                        dos.write(dataBuffer);
                        dos.flush();
                        dos.close();
                        // Parse the json file.
                        InputStream is = new FileInputStream(new File(getFilesDir(), "downloaded_file.json"));
                        int size = is.available();
                        byte[] inputBuffer = new byte[size];
                        is.read(inputBuffer);
                        is.close();
                        String json = new String(inputBuffer, StandardCharsets.UTF_8);
                        resultModel.readJSON(json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

    @Override
    public void exitResult() {
        finish();
    }

    @Override
    public void updateAdapter(final ArrayList<HiringItem> list) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mView.updateItems(list);
            }
        });
    }
}
