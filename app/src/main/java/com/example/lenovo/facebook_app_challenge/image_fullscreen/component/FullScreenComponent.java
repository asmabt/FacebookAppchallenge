package com.example.lenovo.facebook_app_challenge.image_fullscreen.component;

import com.example.lenovo.facebook_app_challenge.app.component.AppComponent;

import com.example.lenovo.facebook_app_challenge.image_fullscreen.FullScreenActivity;
import com.example.lenovo.facebook_app_challenge.image_fullscreen.module.FullScreenModule;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.module.ContextModule;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {FullScreenModule.class, ContextModule.class})
public interface FullScreenComponent {
    void inject(FullScreenActivity fullScreenActivity);
}
