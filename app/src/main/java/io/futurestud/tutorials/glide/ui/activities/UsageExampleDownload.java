package io.futurestud.tutorials.glide.ui.activities;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class UsageExampleDownload extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageAnimateResource();
        loadImageAnimateCode();
    }

    private void loadImageAnimateResource() {
        FutureTarget<File> fileFutureTarget = Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .downloadOnly( 500, 500 );

        try {
            File file = fileFutureTarget.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
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
