package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import io.futurestud.tutorials.glide.transformation.BlurTransformation;
import io.futurestud.tutorials.glide.transformation.RotateTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class UsageExampleTransformations extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageOriginal();
        loadImageTSingleTransformation();
        loadImageMultipleTransformations();
        loadImageTransformationLibrary();
        loadImageRotate();
    }

    private void loadImageOriginal() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                //.transform( new BlurTransformation( context ) )
                //.bitmapTransform( new BlurTransformation( context ) )
                .into( imageView1 );
    }

    private void loadImageTSingleTransformation() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                //.transform( new BlurTransformation( context ) )
                .bitmapTransform( new BlurTransformation( context ) )
                .into( imageView2 );
    }

    private void loadImageMultipleTransformations() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .transform( new RotateTransformation( context, 45f ))
                //.transform( new GrayscaleTransformation( context ), new BlurTransformation( context ) )
                .into( imageView3 );
    }

    private void loadImageTransformationLibrary() {
        Glide
                .with( context )
                .load( eatFoodyImages[2] )
                .bitmapTransform( new jp.wasabeef.glide.transformations.BlurTransformation( context, 25, 2 ), new CropCircleTransformation( context ) )
                .into( imageView4 );
    }

    private void loadImageRotate() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .transform( new RotateTransformation( context, 90f ))
                //.transform( new GrayscaleTransformation( context ), new BlurTransformation( context ) )
                .into( imageView5 );
    }
}
