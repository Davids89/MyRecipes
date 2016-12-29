package com.example.david.myrecipes.libs.base;

import android.widget.ImageView;

/**
 * Created by david on 22/9/16.
 */
public interface ImageLoader {
    void load(ImageView imgAvatar, String url);
    void setOnFinishedImageLoadingListener(Object listener);
}
