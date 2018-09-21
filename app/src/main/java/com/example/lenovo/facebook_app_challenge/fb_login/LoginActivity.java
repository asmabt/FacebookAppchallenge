package com.example.lenovo.facebook_app_challenge.fb_login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import com.example.lenovo.facebook_app_challenge.R;
import com.example.lenovo.facebook_app_challenge.album_list.AlbumListActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.transform.Templates;


public class LoginActivity extends AppCompatActivity {

    private LoginButton myButton;
    private TextView myTextview;
    private CallbackManager myCallbackManager ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        if(AccessToken.getCurrentAccessToken() != null){
            Intent myIntent = new Intent(LoginActivity.this, AlbumListActivity.class);
            startActivity(myIntent);
            finish();

        }

        myButton = findViewById(R.id.fb_login_btn);
        myButton.setReadPermissions("user_about_me");
        myButton.setReadPermissions("user_photos");

        myTextview = findViewById(R.id.text_view);

        myCallbackManager = CallbackManager.Factory.create();

        myButton.registerCallback(myCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent myIntent = new Intent(LoginActivity.this, AlbumListActivity.class);
                startActivity(myIntent);
                finish();

                myTextview.setText("Login on success");
            }

            @Override
            public void onCancel() {

                myTextview.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {

                myTextview.setText("there is an error");
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //pass result to callbackManager
        myCallbackManager.onActivityResult(requestCode, resultCode, data);
    }





}
