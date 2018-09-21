package com.example.lenovo.facebook_app_challenge.app.module;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.lenovo.facebook_app_challenge.used.MyPrefs;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application)
    {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application providedApp(){
        return application;
    }

    @Singleton
    @Provides
    public SharedPreferences sharedPreferences(){
        return application.getSharedPreferences(MyPrefs.myPrefs, MyPrefs.prefs_mode);
    }

}
