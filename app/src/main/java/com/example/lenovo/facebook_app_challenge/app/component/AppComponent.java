package com.example.lenovo.facebook_app_challenge.app.component;

import android.app.Application;

import com.example.lenovo.facebook_app_challenge.app.module.AppModule;


import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application application();
}
