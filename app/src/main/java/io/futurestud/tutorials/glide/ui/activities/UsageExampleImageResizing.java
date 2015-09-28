package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleImageResizing extends AppCompatActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewResize;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewResizeCenterCrop;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewResizeFitCenter;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewResizeScaleDown;
    @InjectView(R.id.standard_list_imageview5) ImageView imageViewFit;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );

        setContentView(R.layout.activity_standard_imageview );
        ButterKnife.inject(this );

        loadImageWithResize();
        loadImageWithResizeCenterCrop();
        loadImageWithResizeFitCenter();
        loadImageWithResizeScaleDown();
    }

    private void loadImageWithResize() {
        Glide
                .with( context )
                .load(UsageExampleListViewAdapter.eatFoodyImages[0] )
                .override( 600, 200 ) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(imageViewResize );
    }

    private void loadImageWithResizeCenterCrop() {
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .override( 600, 200 ) // resizes the image to these dimensions (in pixel)
                .centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .into(imageViewResizeCenterCrop );
    }

    private void loadImageWithResizeFitCenter() {
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .override(600, 200)
                .fitCenter() // this scales the image so that both dimensions are equal to or less than the requested bounds.
                .into( imageViewResizeFitCenter );
    }

    private void loadImageWithResizeScaleDown() {
        // todo figure out if this is possible with glide
        /*
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .override(6000, 2000)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(imageViewResizeScaleDown);
            */
    }
}