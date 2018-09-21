package com.example.lenovo.facebook_app_challenge.image_fullscreen;

import com.facebook.GraphResponse;

public interface FullScreenContract {
    interface FullScreenView{
        void updateView(String pictureUrl);
    }
    interface FullScreenPresenter{
        void getPicture();
        void extractPicture(GraphResponse response);
    }
}
