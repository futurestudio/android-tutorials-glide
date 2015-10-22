package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import io.futurestud.tutorials.glide.glidemodule.CustomImageSizeGlideModule;

import static io.futurestud.tutorials.glide.glidemodule.CustomImageSizeGlideModule.CustomImageSizeUrlLoader;

public class UsageExampleCustomImageSize extends GlideExampleActivity {

    String baseImageUrl = "http://futurestud.io/blog/assets/images/futurestudio-logo.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageWithCustomModel();
        //loadImageWithGlideModule();
    }

    private void loadImageWithCustomModel() {
        CustomImageSizeGlideModule.CustomImageSizeModel customImageRequest = new CustomImageSizeGlideModule.CustomImageSizeModelFutureStudio( baseImageUrl );

        Glide
                .with( context )
                .using( new CustomImageSizeUrlLoader( context ) )
                .load( customImageRequest )
                .into( imageView1 );
    }

    private void loadImageWithGlideModule() {
        CustomImageSizeGlideModule.CustomImageSizeModel customImageRequest = new CustomImageSizeGlideModule.CustomImageSizeModelFutureStudio( baseImageUrl );

        Glide
                .with( context )
                .load( customImageRequest )
                .into( imageView2 );
    }
}
