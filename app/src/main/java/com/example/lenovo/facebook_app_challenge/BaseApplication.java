package com.example.lenovo.facebook_app_challenge;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.example.lenovo.facebook_app_challenge.app.component.DaggerAppComponent;
import com.example.lenovo.facebook_app_challenge.app.component.AppComponent;
import com.example.lenovo.facebook_app_challenge.app.module.AppModule;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BaseApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();






    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
