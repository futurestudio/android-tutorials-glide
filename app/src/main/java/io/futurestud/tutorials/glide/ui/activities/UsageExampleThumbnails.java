package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleThumbnails extends GlideExampleActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageView1;
    @InjectView(R.id.standard_list_imageview2) ImageView imageView2;
    @InjectView(R.id.standard_list_imageview3) ImageView imageView3;
    @InjectView(R.id.standard_list_imageview4) ImageView imageView4;
    @InjectView(R.id.standard_list_imageview5) ImageView imageView5;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

            setContentView( R.layout.activity_standard_imageview );
        ButterKnife.inject( this );

        loadImageOriginal();
        loadImageThumbnailScale();
        loadImageThumbnailRequest();
    }

    private void loadImageOriginal() {
        Glide
                .with( context )
                .load( eatFoodyImages[0] )
                .skipMemoryCache( true )
                .diskCacheStrategy( DiskCacheStrategy.NONE )
                .into( imageView1 );
    }

    private void loadImageThumbnailScale() {
        Glide
                .with( context )
                .load( UsageExampleGifAndVideos.gifUrl )
                .skipMemoryCache( true )
                .diskCacheStrategy( DiskCacheStrategy.NONE )
                .thumbnail( 0.1f )
                .into( imageView2 );
    }

    private void loadImageThumbnailRequest() {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with( context )
                .load( eatFoodyImages[2] )
                .skipMemoryCache( true )
                .diskCacheStrategy( DiskCacheStrategy.NONE );

        Glide
                .with( context )
                .load( UsageExampleGifAndVideos.gifUrl )
                .skipMemoryCache( true )
                .diskCacheStrategy( DiskCacheStrategy.NONE )
                .thumbnail( thumbnailRequest )
                .into( imageView3 );
    }

}
