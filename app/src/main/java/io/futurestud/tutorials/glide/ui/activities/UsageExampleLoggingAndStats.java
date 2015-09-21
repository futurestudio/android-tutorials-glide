package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.StatsSnapshot;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleLoggingAndStats extends AppCompatActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewFromMemory;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewFromDisk;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewFromNetwork;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        // enabling cache indicators
        Picasso
                .with(context)
                .setIndicatorsEnabled(true);

        // enable logging
        Picasso
                .with(context)
                .setLoggingEnabled(true);

        loadImageBitmapFromMemory();
        loadImageBitmapFromDisk();
        loadImageBitmapFromNetwork();

        printPicassoStatsSnapshot();
    }

    /**
     * This method makes sure that the image is in memory by using .fetch().
     * After the request is successful, it'll load the image into the ImageView.
     * In 99% of the cases, this should result in the image still being in the memory cache.
     */
    private void loadImageBitmapFromMemory() {
        Picasso.with(context).load(UsageExampleListViewAdapter.eatFoodyImages[0]).fetch(new Callback() {
            @Override
            public void onSuccess() {
                Picasso
                        .with(context)
                        .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                        .into(imageViewFromMemory);
            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * Just like the loadImageBitmapFromMemory() method, we first call fetch() to load the image in our caches.
     * In order to make sure this image does not come from the memory cache, we specifically set the request to ignore the memory cache with .memoryPolicy().
     * This should result in 99% of the cases that the image loads from the disk cache.
     */
    private void loadImageBitmapFromDisk() {
        Picasso.with(context).load(UsageExampleListViewAdapter.eatFoodyImages[1]).fetch(new Callback() {
            @Override
            public void onSuccess() {
                Picasso
                        .with(context)
                        .load(UsageExampleListViewAdapter.eatFoodyImages[1])
                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                        .into(imageViewFromDisk);
            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * This method forces the image to be loaded from the network by skipping the caches.
     */
    private void loadImageBitmapFromNetwork() {
        Picasso
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[2])
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageViewFromNetwork);
    }

    /**
     * overarching stats of all Picasso requests
     */
    private void printPicassoStatsSnapshot() {
        StatsSnapshot picassoStats = Picasso.with(context).getSnapshot();

        // you could set the debugger here to analyze the picassoStats object

        // or print the stats to Android Logcat
        Log.d("Picasso Stats", picassoStats.toString());
    }
}
