package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleRequestPriority extends AppCompatActivity {

    @BindView(R.id.activity_request_priority_hero) ImageView imageViewHero;
    @BindView(R.id.activity_request_priority_low_left) ImageView imageViewLowPrioLeft;
    @BindView(R.id.activity_request_priority_low_right) ImageView imageViewLowPrioRight;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_request_priority );
        ButterKnife.bind( this );

        loadImageWithHighPriority();
        loadImagesWithLowPriority();
        //loadImageWithNormalPriority();
        //loadImageWithImmediatePriority();
    }

    private void loadImageWithHighPriority() {
        Glide
                .with( context )
                .load( UsageExampleListViewAdapter.eatFoodyImages[0] )
                .priority( Priority.HIGH )
                .into( imageViewHero );
    }

    private void loadImagesWithLowPriority() {
        Glide
                .with( context )
                .load( UsageExampleListViewAdapter.eatFoodyImages[1] )
                .priority(Priority.LOW)
                .into(imageViewLowPrioLeft);

        Glide
                .with( context )
                .load( UsageExampleListViewAdapter.eatFoodyImages[2] )
                .priority(Priority.LOW)
                .into(imageViewLowPrioRight);
    }

    private void loadImageWithNormalPriority() {
        Glide
                .with( context )
                .load( UsageExampleListViewAdapter.eatFoodyImages[0] )
                .priority( Priority.NORMAL )
                .into( imageViewHero );
    }

    private void loadImageWithImmediatePriority() {
        Glide
                .with( context )
                .load( UsageExampleListViewAdapter.eatFoodyImages[0] )
                .priority( Priority.IMMEDIATE )
                .into(imageViewHero);
    }
}