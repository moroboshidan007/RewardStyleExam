package com.example.rewardstyleexam.util;

/**
 * Object to manage hiring item.
 * @author Yinghao Li
 * @since 2021-03-29
 */
public class HiringItem {

    private int id;
    private int listId;
    private String name;

    public HiringItem(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }
}
