package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleSimpleLoading extends AppCompatActivity {

    public static final String ANDROID_RESOURCE = "android.resource://";
    public static final String FOREWARD_SLASH = "/";

    @BindView(R.id.simple_loading_internet) ImageView imageViewInternet;
    @BindView(R.id.simple_loading_resource) ImageView imageViewResource;
    @BindView(R.id.simple_loading_file) ImageView imageViewFile;
    @BindView(R.id.simple_loading_uri) ImageView imageViewUri;

    private Context context = this;

    /**
     * helper method which creates an Uri for a resourceId
     */
    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + FOREWARD_SLASH + resourceId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_simple_loading);
        ButterKnife.bind(this);

        loadImageByInternetUrl();
        loadImageByResourceId();
        loadImageByFile();
        loadImageByUri();
    }

    private void loadImageByInternetUrl() {
        // the url could be any image URL, which is accessible with a normal HTTP GET request
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        Glide
                .with( context )
                .load(internetUrl)
                .into(imageViewInternet);
    }

    private void loadImageByResourceId() {
        int resourceId = R.mipmap.ic_launcher;
        Glide
                .with(context)
                .load(resourceId)
                .into(imageViewResource);
    }

    private void loadImageByFile() {
        // this file probably does not exist on your device. However, you can use any file path, which points to an image file
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Running.jpg");
        Glide
                .with(context)
                .load(file)
                .into(imageViewFile);
    }

    private void loadImageByUri() {
        // this could be any Uri. for demonstration purposes we're just creating an Uri pointing to a launcher icon
        Uri uri = resourceIdToUri(context, R.mipmap.future_studio_launcher);
        Glide
                .with(context)
                .load(uri)
                .into(imageViewUri);
    }
}
