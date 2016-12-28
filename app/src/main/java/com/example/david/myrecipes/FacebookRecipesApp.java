package com.example.david.myrecipes;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by david on 28/12/16.
 */

public class FacebookRecipesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }
}
