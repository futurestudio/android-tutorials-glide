package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

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

    public static String gifUrl = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.inject( this );

        loadGif();
        loadGifAsBitmap();
        loaLocalVideo();
    }

    private void loadGif() {

        Glide
                .with( context )
                .load( gifUrl )
                .asGif()
                .error( R.drawable.full_cake )
                .into( imageViewGif );
    }

    private void loadGifAsBitmap() {
        Glide
                .with( context )
                .load( gifUrl )
                .asBitmap()
                .thumbnail( 0.5f )
                .placeholder( R.drawable.cupcake )
                .into( imageViewGifAsBitmap );
    }

    private void loaLocalVideo() {
        // todo select a common video file
        String filePath = "/storage/emulated/0/Pictures/example_video.mp4";

        Glide
                .with( context )
                .load( Uri.fromFile( new File( filePath ) ) )
                .error( R.drawable.cupcake )
                .into( imageViewLocalVideo );
    }

}