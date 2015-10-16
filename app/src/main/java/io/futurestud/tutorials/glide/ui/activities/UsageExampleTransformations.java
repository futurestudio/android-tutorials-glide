package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import io.futurestud.tutorials.glide.transformation.BlurTransformation;
import io.futurestud.tutorials.glide.transformation.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class UsageExampleTransformations extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageOriginal();
        loadImageThumbnailScale();
        loadImageThumbnailRequest();
    }

    private void loadImageOriginal() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .transform( new BlurTransformation( context ) )
                .into( imageView1 );
    }

    private void loadImageThumbnailScale() {
        Glide
                .with( context )
                .load( eatFoodyImages[1] )
                .transform( new GrayscaleTransformation( context ), new BlurTransformation( context ) )
                .into( imageView2 );
    }

    private void loadImageThumbnailRequest() {
        Glide
                .with( context )
                .load( eatFoodyImages[2] )
                .bitmapTransform( new jp.wasabeef.glide.transformations.BlurTransformation( context, 25, 2 ), new CropCircleTransformation( context ) )
                .into( imageView3 );
    }
}
