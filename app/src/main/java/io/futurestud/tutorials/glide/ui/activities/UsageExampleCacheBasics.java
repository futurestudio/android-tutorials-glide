package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleCacheBasics extends GlideExampleActivity {

    @BindView(R.id.simple_loading_internet) ImageView imageViewInternet;
    @BindView(R.id.simple_loading_resource) ImageView imageViewResource;
    @BindView(R.id.simple_loading_file) ImageView imageViewFile;
    @BindView(R.id.simple_loading_uri) ImageView imageViewUri;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_simple_loading);
        ButterKnife.bind(this);

        loadImageSkipMemory();
        loadImageSkipMemoryAndDisk();
        loadImageDiskStrategySource();
        loadImageDiskStrategyResult();
    }

    private void loadImageSkipMemory() {
        Glide
                .with(context)
                .load(eatFoodyImages[0])
                .skipMemoryCache(true)
                .into(imageViewInternet);
    }

    private void loadImageSkipMemoryAndDisk() {
        Glide
                .with(context)
                .load(eatFoodyImages[1])
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageViewResource);
    }

    private void loadImageDiskStrategySource() {
        Glide
                .with(context)
                .load(eatFoodyImages[2])
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageViewFile);
    }

    private void loadImageDiskStrategyResult() {
        Glide
                .with(context)
                .load(eatFoodyImages[3])
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imageViewUri);
    }
}
