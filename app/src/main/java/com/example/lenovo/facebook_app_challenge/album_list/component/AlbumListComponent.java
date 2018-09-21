package com.example.lenovo.facebook_app_challenge.album_list.component;

import com.example.lenovo.facebook_app_challenge.album_list.AlbumListActivity;
import com.example.lenovo.facebook_app_challenge.album_list.module.AlbumListModule;
import com.example.lenovo.facebook_app_challenge.app.component.AppComponent;
import com.example.lenovo.facebook_app_challenge.used.ActivityScope;
import com.example.lenovo.facebook_app_challenge.used.module.ContextModule;

import dagger.Component;


@ActivityScope
@Component(dependencies = AppComponent.class, modules = {AlbumListModule.class, ContextModule.class})
public interface AlbumListComponent {
    void inject(AlbumListActivity albumListActivity);
}
