package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class UsageExampleTargetsAndRemoteViews extends GlideExampleActivity {

    private static final int NOTIFICATION_ID = 34567;

    private SimpleTarget target = new SimpleTarget<GlideBitmapDrawable>() {
        @Override
        public void onResourceReady(GlideBitmapDrawable bitmap, GlideAnimation glideAnimation) {
            imageView1.setImageBitmap( bitmap.getBitmap() );
        }
    };

    private SimpleTarget target2 = new SimpleTarget<GlideBitmapDrawable>(250, 250) {
        @Override
        public void onResourceReady(GlideBitmapDrawable bitmap, GlideAnimation glideAnimation) {
            imageView2.setImageBitmap( bitmap.getBitmap() );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageSimpleTarget();
        loadImageSimpleTargetApplicationContext();
    }

    private void loadImageSimpleTarget() {
        Glide
                .with( context ) // could be an issue!
                .load( eatFoodyImages[0] )
                .asBitmap()
                .into( target );
    }

    private void loadImageSimpleTargetApplicationContext() {
        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[1] )
                .asBitmap()
                .into( target2 );
    }

    // todo implement viewtargets
    private void loadImageViewTarget() {
        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[1] )
                .asBitmap()
                .into( target2 );
    }

    // todo add custom view class

    /*
    // todo remoteviews and notifications
    private void loadImageSimpleTargetApplicationContext() {
        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[0] )
                .asBitmap()
                .into( target2 );
    }
    */

    // todo todo add appwidgets
}
