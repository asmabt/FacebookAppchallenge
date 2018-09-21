package com.example.lenovo.facebook_app_challenge.images_grid;

import com.example.lenovo.facebook_app_challenge.images_grid.model.Image;
import com.facebook.GraphResponse;

import java.util.List;

public interface GridImageContract {

    interface GridImageView{
        void updatePictureGrid(List<Image> pictureList);
    }
    interface GridPicturePresenter{
        void getPictures();
        void extractPictures(GraphResponse response);
    }
}
