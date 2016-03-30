package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExamplePlaceholders extends AppCompatActivity {

    @Bind(R.id.standard_list_imageview1) ImageView imageViewPlaceholder;
    @Bind(R.id.standard_list_imageview2) ImageView imageViewError;
    @Bind(R.id.standard_list_imageview3) ImageView imageViewNoFade;
    @Bind(R.id.standard_list_imageview4) ImageView imageViewCombined;
    @Bind(R.id.standard_list_imageview5) ImageView imageViewNoPlaceholder;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.bind( this );

        loadImageWithPlaceholder();
        loadImageWithError();
        loadImageNoAnimation();
        loadImageFallback();
        loadImageCombination();

        loadImageWithNoPlaceholder();
    }

    private void loadImageWithPlaceholder() {
        Glide
                .with( context )
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .placeholder( R.mipmap.ic_launcher ) // can also be a drawable
                .into( imageViewPlaceholder );
    }

    private void loadImageWithError() {
        Glide
                .with(context)
                .load("http://futurestud.io/non_existing_image.png")
                .error( R.mipmap.future_studio_launcher ) // will be displayed if the image cannot be loaded
                .into( imageViewError );
    }

    private void loadImageNoAnimation() {
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .dontAnimate()
                .into( imageViewNoFade );
    }

    private void loadImageFallback() {
        String nullString = null; // could be set to null dynamically

        Glide
                .with(context)
                .load( nullString )
                .fallback( R.drawable.floorplan )
                .into( imageViewNoFade );
    }

    private void loadImageCombination() {
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.mipmap.future_studio_launcher) // will be displayed if the image cannot be loaded
                .crossFade( 1000 )
                .into( imageViewCombined );
    }

    private void loadImageWithNoPlaceholder() {
        // todo figure out if this is supported by glide
        // load an image into the imageview
        /*
        Glide
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(imageViewNoPlaceholder, new Callback() {
                    @Override
                    public void onSuccess() {
                        // once the image is loaded, load the next image
                        Picasso
                                .with(context)
                                .load(UsageExampleListViewAdapter.eatFoodyImages[1])
                                .noPlaceholder() // but don't clear the imageview or set a placeholder; just leave the previous image in until the new one is ready
                                .into(imageViewNoPlaceholder);
                    }

                    @Override
                    public void onError() {

                    }
                });
        */

    }
}