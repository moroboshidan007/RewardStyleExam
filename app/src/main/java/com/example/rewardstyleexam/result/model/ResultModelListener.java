package com.example.rewardstyleexam.result.model;

import com.example.rewardstyleexam.util.HiringItem;

import java.util.ArrayList;

/**
 * Listener to monitor the change in datq parsing.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public interface ResultModelListener {
    void updateAdapter(ArrayList<HiringItem> list);
}
