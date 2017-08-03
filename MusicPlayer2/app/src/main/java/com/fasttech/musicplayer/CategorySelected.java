package com.fasttech.musicplayer;

import android.graphics.Bitmap;

/**
 * Created by dell on 7/27/2017.
 */

public class CategorySelected {
    String albumname;
    int image;

    public CategorySelected() {
    }

    public CategorySelected(String albumname, int image) {
        this.albumname = albumname;
        this.image = image;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
