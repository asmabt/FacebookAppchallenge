package com.example.lenovo.facebook_app_challenge.images_grid.module;

import com.example.lenovo.facebook_app_challenge.images_grid.GridImageContract;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModel;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModelInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class GridImagesModule {

    private GridImageContract.GridImageView view;

    public GridImagesModule(GridImageContract.GridImageView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public GridImageContract.GridImageView provideView(){
        return view;
    }

    @ActivityScope
    @Provides
    public FacebookDataModelInterface provideModel(){
        return new FacebookDataModel();
    }
}

