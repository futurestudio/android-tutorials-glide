package io.futurestud.tutorials.glide.ui.activities;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;

import io.futurestud.tutorials.glide.R;

public class UsageExampleAnimate extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageAnimateResource();
        loadImageAnimateCode();
    }

    private void loadImageAnimateResource() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .animate( R.anim.zoom_in )
                .into( imageView1 );
    }

    private void loadImageAnimateCode() {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                view.setAlpha( 0f );

                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
                fadeAnim.setDuration( 2500 );
                fadeAnim.start();
            }
        };

        Glide
                .with( context )
                .load( eatFoodyImages[1] )
                .animate( animationObject )
                .into( imageView2 );
    }
}
