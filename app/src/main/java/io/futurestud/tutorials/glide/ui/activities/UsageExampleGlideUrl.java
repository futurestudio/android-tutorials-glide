package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleGlideUrl extends AppCompatActivity {

    @Bind(R.id.standard_list_imageview1) ImageView imageViewGif;
    @Bind(R.id.standard_list_imageview2) ImageView imageViewGifAsBitmap;
    @Bind(R.id.standard_list_imageview3) ImageView imageViewLocalVideo;
    @Bind(R.id.standard_list_imageview4) ImageView imageViewCombined;
    @Bind(R.id.standard_list_imageview5) ImageView imageViewNoPlaceholder;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.bind( this );

        loadFirst();
        loadSecond();
    }

    private void loadFirst() {
        Glide
                .with( context )
                .load("http://i.imgur.com/rFLNqWI.jpg?test=test")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        loadSecond();
                        return false;
                    }
                })
                .into( imageViewGif );
    }


    private void loadSecond() {
        Toast.makeText(context, "loading 2", Toast.LENGTH_SHORT).show();

        Glide
                .with( context )
                .load("http://i.imgur.com/rFLNqWI.jpg?test=test2")
                .into( imageViewGifAsBitmap );
    }

    public class GlideUrlWithToken extends GlideUrl {
        private String mSourceUrl;

        public GlideUrlWithToken(String url, String token) {
            super(new StringBuilder(url)
                    .append(url.contains("?") ? "&token=" : "?token=") //already has other parameters
                    .append(token) // append the token at the end of url
                    .toString());

            mSourceUrl = url;
        }

        @Override
        public String getCacheKey() {
            return mSourceUrl;
        }

        @Override
        public String toString() {
            return super.getCacheKey();
        }
    }

}