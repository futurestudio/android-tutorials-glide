package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class UsageExampleThumbnails extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loadImageOriginal();
        loadImageThumbnailScale();
        loadImageThumbnailRequest();
    }

    private void loadImageOriginal() {
        Glide
                .with(context)
                .load(eatFoodyImages[0])
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView1);
    }

    private void loadImageThumbnailScale() {
        Glide
                .with(context)
                .load(eatFoodyImages[1])
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .thumbnail(0.1f)
                .into(imageView2);
    }

    private void loadImageThumbnailRequest() {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(context)
                .load(eatFoodyImages[2])
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide
                .with(context)
                .load(UsageExampleGifAndVideos.gifUrl)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .thumbnail(thumbnailRequest)
                .into(imageView3);
    }

}
