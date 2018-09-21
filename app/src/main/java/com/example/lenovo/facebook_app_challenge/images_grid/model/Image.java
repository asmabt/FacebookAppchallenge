package com.example.lenovo.facebook_app_challenge.images_grid.model;

public class Image {

    String id, imgUrl;

    public Image(String id, String imgUrl) {
        this.id = id;
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public String getPictureUrl() {
        return imgUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPictureUrl(String pictureUrl) {
        this.imgUrl = pictureUrl;
    }
}


