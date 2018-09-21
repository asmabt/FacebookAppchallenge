package com.example.lenovo.facebook_app_challenge.image_fullscreen.module;

import com.example.lenovo.facebook_app_challenge.image_fullscreen.FullScreenContract;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModel;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModelInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class FullScreenModule {

    private FullScreenContract.FullScreenView view;

    public FullScreenModule(FullScreenContract.FullScreenView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public FullScreenContract.FullScreenView provideView() {
        return view;
    }

    @ActivityScope
    @Provides
    public FacebookDataModelInterface provideModel(){
        return new FacebookDataModel();
    }
}
