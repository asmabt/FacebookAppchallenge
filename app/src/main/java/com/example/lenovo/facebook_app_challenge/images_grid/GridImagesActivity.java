package com.example.lenovo.facebook_app_challenge.images_grid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.lenovo.facebook_app_challenge.BaseApplication;
import com.example.lenovo.facebook_app_challenge.R;
import com.example.lenovo.facebook_app_challenge.fb_login.LoginActivity;
import com.example.lenovo.facebook_app_challenge.image_fullscreen.FullScreenActivity;
import com.example.lenovo.facebook_app_challenge.images_grid.adapter.ImageGridAdapter;
import com.example.lenovo.facebook_app_challenge.images_grid.component.DaggerGridImagesComponent;
import com.example.lenovo.facebook_app_challenge.images_grid.model.Image;
import com.example.lenovo.facebook_app_challenge.images_grid.module.GridImagesModule;
import com.example.lenovo.facebook_app_challenge.used.module.ContextModule;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GridImagesActivity extends AppCompatActivity implements GridImageContract.GridImageView {

    private CallbackManager mCallBackManager;
    private GridView grid;
    private ImageGridAdapter adapter;
    @Inject
    GridImagesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_images);

        injectDaggerGridPicturesComponent();
        setUpPictureGrid();
        presenter.getPictures();
        mCallBackManager = CallbackManager.Factory.create();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallBackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout :
                startActivity(new Intent(GridImagesActivity.this, LoginActivity.class));
                LoginManager.getInstance().logOut();
                finish();
                return true;

            default:
                return true;
        }
    }

    @Override
    public void updatePictureGrid(List<Image> pictureList) {
        adapter.updatePictures(pictureList);
    }

    private void injectDaggerGridPicturesComponent(){
        DaggerGridImagesComponent.builder()

               .appComponent(((BaseApplication)getApplicationContext()).getAppComponent())
                .contextModule(new ContextModule(this))
                .gridImagesModule(new GridImagesModule(this))
                .build()
                .inject(this);

    }

    private void setUpPictureGrid(){
        grid = findViewById(R.id.grid);
        adapter = new ImageGridAdapter(this, new ArrayList<Image>());
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(GridImagesActivity.this, FullScreenActivity.class);
                intent.putExtra("id", String.valueOf(l));
                startActivity(intent);
            }
        });
    }
}

