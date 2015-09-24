package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleGifAndVideos extends AppCompatActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewGif;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewGifAsBitmap;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewLocalVideo;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewCombined;
    @InjectView(R.id.standard_list_imageview5) ImageView imageViewNoPlaceholder;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.inject( this );

        //loadGif();
        //loadGifAsBitmap();
        loaLocalVideo();
    }

    private void loadGif() {

        Glide
                .with( context )
                .load( "https://thechive.files.wordpress.com/2015/09/tumblr_nttnamo71n1tpm1nfo1_500.gif" )
                .asGif()
                .error( R.drawable.full_cake )
                .into( imageViewGif );
    }

    private void loadGifAsBitmap() {
        Glide
                .with( context )
                .load( "https://thechive.files.wordpress.com/2015/09/tumblr_nttnamo71n1tpm1nfo1_500.gif" )
                .asBitmap()
                .placeholder( R.drawable.cupcake )
                .into( imageViewGifAsBitmap );
    }

    private void loaLocalVideo() {
        Glide
                .with( context )
                .load( R.raw.test_video )
                .into( imageViewLocalVideo );
    }

}