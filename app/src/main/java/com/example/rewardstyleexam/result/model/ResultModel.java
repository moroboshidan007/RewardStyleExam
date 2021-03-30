package com.example.rewardstyleexam.result.model;

import com.example.rewardstyleexam.util.HiringItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ResultModel {

    private ArrayList<HiringItem> mList;
    private ResultModelListener mListener;

    public ResultModel(ResultModelListener listener) {
        mList = new ArrayList<>();
        mListener = listener;
    }

    public void readJSON(String json) {
        try {
            JSONArray array = new JSONArray(json);
            for (int item = 0; item < array.length(); item++) {
                JSONObject object = array.getJSONObject(item);
                int id = object.getInt("id");
                int listId = object.getInt("listId");
                String name = object.getString("name");
                if (!name.equals("null") && !name.isEmpty()) {
                    HiringItem hiringItem = new HiringItem(id, listId, name);
                    mList.add(hiringItem);
                }
                if (!mList.isEmpty()) {
                    Collections.sort(mList, new Comparator<HiringItem>() {
                        @Override
                        public int compare(HiringItem o1, HiringItem o2) {
                            if (o1.getListId() > o2.getListId()) {
                                return 1;
                            } else if (o1.getListId() == o2.getListId()) {
                                return o1.getName().compareTo(o2.getName());
                            } else {
                                return -1;
                            }
                        }
                    });
                    mListener.updateAdapter(mList);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
