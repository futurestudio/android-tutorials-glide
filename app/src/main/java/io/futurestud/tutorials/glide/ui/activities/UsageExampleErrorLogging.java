package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleErrorLogging extends GlideExampleActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewPlaceholder;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewError;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewNoFade;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewCombined;
    @InjectView(R.id.standard_list_imageview5) ImageView imageViewNoPlaceholder;

    private RequestListener<String, GlideDrawable> requestListener = new RequestListener<String, GlideDrawable>() {
        @Override
        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
            // todo log exception

            // important to return false so the error placeholder can be placed
            return false;
        }

        @Override
        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        loadImageWithErrorLogging();
    }

    private void loadImageWithErrorLogging() {
        Glide
                .with( context )
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .listener( requestListener )
                .error( R.drawable.cupcake )
                .into( imageViewPlaceholder );
    }

}