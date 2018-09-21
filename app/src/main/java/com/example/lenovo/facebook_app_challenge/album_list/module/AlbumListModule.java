package com.example.lenovo.facebook_app_challenge.album_list.module;

import dagger.Module;
import dagger.Provides;


import com.example.lenovo.facebook_app_challenge.album_list.AlbumListContract;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModel;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModelInterface;

@Module
public class AlbumListModule {
    private AlbumListContract.AlbumListView view;

    public AlbumListModule(AlbumListContract.AlbumListView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public AlbumListContract.AlbumListView provideContext(){
        return view;
    }

    @ActivityScope
    @Provides
    public FacebookDataModelInterface provideModel(){
        return new FacebookDataModel();
    }
}