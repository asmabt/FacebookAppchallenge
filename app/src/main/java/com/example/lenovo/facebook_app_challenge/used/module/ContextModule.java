package com.example.lenovo.facebook_app_challenge.used.module;

import android.content.Context;

import com.example.lenovo.facebook_app_challenge.used.ActivityScope;

import dagger.Module;
import dagger.Provides;
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @ActivityScope
    @Provides
    public Context provideContext(){
        return context;
    }
}

