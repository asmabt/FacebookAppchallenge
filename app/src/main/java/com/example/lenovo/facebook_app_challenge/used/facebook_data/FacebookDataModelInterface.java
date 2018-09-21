package com.example.lenovo.facebook_app_challenge.used.facebook_data;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;

public interface FacebookDataModelInterface {
    void executeGraphRequest(AccessToken accessToken, String graphPath, GraphRequest.Callback callback);
}
