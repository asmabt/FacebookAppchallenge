package com.example.lenovo.facebook_app_challenge.images_grid.component;

import com.example.lenovo.facebook_app_challenge.app.component.AppComponent;
import com.example.lenovo.facebook_app_challenge.images_grid.GridImagesActivity;
import com.example.lenovo.facebook_app_challenge.images_grid.module.GridImagesModule;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.module.ContextModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {GridImagesModule.class, ContextModule.class})
public interface GridImagesComponent {
    void inject(GridImagesActivity gridImagesActivity);
}
