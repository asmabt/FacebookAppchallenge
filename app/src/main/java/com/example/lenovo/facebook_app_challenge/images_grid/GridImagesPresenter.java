package com.example.lenovo.facebook_app_challenge.images_grid;

import android.content.Context;

import com.example.lenovo.facebook_app_challenge.images_grid.model.Image;
import com.example.lenovo.facebook_app_challenge.used.facebook_data.FacebookDataModelInterface;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GridImagesPresenter implements GridImageContract.GridPicturePresenter {

    private GridImageContract.GridImageView view;
    private FacebookDataModelInterface model;
    @Inject
    Context context;

    @Inject
    public GridImagesPresenter(GridImageContract.GridImageView view, FacebookDataModelInterface model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void getPictures() {
        String albumId = ((GridImagesActivity) context).getIntent().getStringExtra("id");
        String graphPath = "/" + albumId + "/photos?fields=picture";

        GraphRequest.Callback responseCallback = new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                extractPictures(response);
            }
        };

        model.executeGraphRequest(AccessToken.getCurrentAccessToken(), graphPath, responseCallback);
    }

    @Override
    public void extractPictures(GraphResponse response) {
        List<Image> pictures = new ArrayList<>();
        try {
            JSONObject dataResponse = response.getJSONObject();
            JSONArray data = dataResponse.getJSONArray("data");


            for (int i = 0; i < data.length(); i++) {
                pictures.add(new Image(
                        data.getJSONObject(i).getString("id"),
                        data.getJSONObject(i).getString("picture")
                ));

            }
            view.updatePictureGrid(pictures);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

