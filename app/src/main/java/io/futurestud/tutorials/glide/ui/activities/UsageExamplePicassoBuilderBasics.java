package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.okhttp.UnsafeOkHttpClient;

public class UsageExamplePicassoBuilderBasics extends ActionBarActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageView1;
    @InjectView(R.id.standard_list_imageview2) ImageView imageView2;
    @InjectView(R.id.standard_list_imageview3) ImageView imageView3;
    @InjectView(R.id.standard_list_imageview4) ImageView imageView4;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        loadImageViaLocalPicassoInstance();
        loadImageViaGlobalPicassoInstance();
        loadImageViaOkHttpPicassoInstance();
        loadImageViaUnsafeOkHttpPicassoInstance();
    }

    private void loadImageViaLocalPicassoInstance() {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        // Picasso.Builder creates the Picasso object to do the actual requests
        Picasso picasso = picassoBuilder.build();

        // instead of Picasso.with(Context context) you directly use this picasso object
        picasso
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .into(imageView1);
    }

    private void loadImageViaGlobalPicassoInstance() {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        // Picasso.Builder creates the Picasso object to do the actual requests
        Picasso picasso = picassoBuilder.build();

        // set the global instance to use this picasso object
        // all following Picasso (with Picasso.with(Context context) requests will use this picasso object
        // you can only use the setSingletonInstance() method once!
        try {
            Picasso.setSingletonInstance(picasso);
        } catch (IllegalStateException ignored) {
            // Picasso instance was already set
            // cannot set it after Picasso.with(Context) was already used
        }

        // you can continue to use Picasso.with(Context context)
        Picasso
                .with(UsageExamplePicassoBuilderBasics.this)
                .load(UsageExampleListViewAdapter.eatFoodyImages[1])
                .into(imageView2);
    }


    private void loadImageViaOkHttpPicassoInstance() {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        // let's change the standard behavior before we create the Picasso instance
        // for example, let's switch out the standard downloader for the OkHttpClient
        picassoBuilder.downloader(new OkHttpDownloader(new OkHttpClient()));

        // Picasso.Builder creates the Picasso object to do the actual requests
        Picasso picasso = picassoBuilder.build();

        picasso
                .load(UsageExampleListViewAdapter.eatFoodyImages[2])
                .into(imageView3);
    }

    private void loadImageViaUnsafeOkHttpPicassoInstance() {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        // let's change the standard behavior before we create the Picasso instance
        // for example, let's switch out the standard downloader for the OkHttpClient
        // this OkHttpClient is special since it allows connection to HTTPS urls with a self-signed certificate
        picassoBuilder.downloader(new OkHttpDownloader(UnsafeOkHttpClient.getUnsafeOkHttpClient()));

        // you could further modify Picasso's behavior here, for example setting a custom cache implementation
        // but that would go too far for this tutorial

        // Picasso.Builder creates the Picasso object to do the actual requests
        Picasso picasso = picassoBuilder.build();

        picasso
                .load(UsageExampleListViewAdapter.eatFoodyImages[3])
                .into(imageView4);
    }
}
