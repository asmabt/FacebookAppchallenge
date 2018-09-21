package com.example.lenovo.facebook_app_challenge.image_fullscreen;

import android.content.Context;

import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModelInterface;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

public class FullScreenPresenter implements FullScreenContract.FullScreenPresenter {

    private FullScreenContract.FullScreenView view;
    private FacebookDataModelInterface model;
    @Inject
    Context context;

    @Inject
    public FullScreenPresenter(FullScreenContract.FullScreenView view, FacebookDataModelInterface model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void getPicture() {
        String albumId = ((FullScreenActivity) context).getIntent().getStringExtra("id");
        String graphPath = "/" + albumId + "/?fields=images";

        GraphRequest.Callback responseCallback = new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                extractPicture(response);
            }
        };

        model.executeGraphRequest(AccessToken.getCurrentAccessToken(), graphPath, responseCallback);
    }

    @Override
    public void extractPicture(GraphResponse response) {
        try {
            JSONObject dataResponse = response.getJSONObject();
            JSONArray data = dataResponse.getJSONArray("images");

            view.updateView(data.getJSONObject(0).getString("source"));

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}

