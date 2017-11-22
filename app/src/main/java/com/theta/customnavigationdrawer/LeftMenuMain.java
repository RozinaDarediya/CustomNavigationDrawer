package com.theta.customnavigationdrawer;

import java.io.Serializable;

/**
 * Created by arbaz on 6/2/17.
 */
public class LeftMenuMain implements Serializable {
    public String ItemName;
    public int imgResID;
    public String shortlist_count;

    public LeftMenuMain(String itemName, int imgResID, String shortlist_count) {
        ItemName = itemName;
        this.imgResID = imgResID;
        this.shortlist_count = shortlist_count;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getImgResID() {
        return imgResID;
    }

    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }

    public String getShortlist_count() {
        return shortlist_count;
    }

    public void setShortlist_count(String shortlist_count) {
        this.shortlist_count = shortlist_count;
    }
}
