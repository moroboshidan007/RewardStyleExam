package com.example.rewardstyleexam.result.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.rewardstyleexam.R;
import com.example.rewardstyleexam.result.view.ResultView;
import com.example.rewardstyleexam.result.view.ResultViewListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

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

        Intent intent = getIntent();
        assert intent != null;
        final String fileName = intent.getStringExtra("file_name");
        if (fileName != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(fileName);
                        URLConnection connection = url.openConnection();
                        int length = connection.getContentLength();
                        DataInputStream dis = new DataInputStream(url.openStream());
                        byte[] buffer = new byte[length];
                        dis.readFully(buffer);
                        dis.close();
                        DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(getFilesDir(), "downloaded_file.json")));
                        dos.write(buffer);
                        dos.flush();
                        dos.close();
                        //System.out.println("successfully downloaded the file!");
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
}
