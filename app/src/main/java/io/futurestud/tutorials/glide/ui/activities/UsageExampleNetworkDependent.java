package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.glidemodule.NetworkDisablingLoader;

public class UsageExampleNetworkDependent extends AppCompatActivity {

    @Bind(R.id.standard_list_imageview1) ImageView imageView1;
    @Bind(R.id.standard_list_imageview3) ImageView imageView2;
    @Bind(R.id.standard_list_imageview4) ImageView imageView3;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.bind(this);

        //loadNetworkDependent();
        loadNetworkDependentWithCache();
    }

    private void loadNetworkDependent() {
        RequestManager requestManager = Glide.with(context);
        DrawableTypeRequest<String> request;

        // if you need transformations or other options specific for the load, chain them here
        if (deviceOnWifi()) {
            request = requestManager.load("http://www.placehold.it/750x750");
        }
        else {
            request = requestManager.load("http://www.placehold.it/100x100");
        }

        request.into(imageView1);
    }

    private void loadNetworkDependentWithCache() {
        // if you need transformations or other options specific for the load, chain them here
        if (deviceOnWifi()) {
            Glide
                    .with(context)
                    .load("http://www.placehold.it/750x750")
                    .into(imageView1);
        }
        else {
            Glide
                    .with(context)
                    .using(new NetworkDisablingLoader())
                    .load("http://www.placehold.it/750x750")
                    .thumbnail(
                        Glide
                                .with(context)
                                .load("http://www.placehold.it/100x100")
                    )
                    .into(imageView1);

        }

    }


    private boolean deviceOnWifi() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        return networkInfo.isConnected();
    }


}