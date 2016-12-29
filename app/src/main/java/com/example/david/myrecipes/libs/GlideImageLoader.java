package com.example.david.myrecipes.libs;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.example.david.myrecipes.libs.base.ImageLoader;

/**
 * Created by david on 9/12/16.
 */

public class GlideImageLoader implements ImageLoader {

    private RequestManager glideRequestManager;
    private RequestListener onFinishedLoadingListener;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public void load(ImageView imgAvatar, String url) {

        if(onFinishedLoadingListener != null){
            glideRequestManager
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .listener(onFinishedLoadingListener)
                    .into(imgAvatar);
        }else{
            glideRequestManager
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(imgAvatar);
        }
    }

    @Override
    public void setOnFinishedImageLoadingListener(Object listener) {
        if(listener instanceof RequestListener){
            this.onFinishedLoadingListener = (RequestListener) listener;
        }
    }
}
