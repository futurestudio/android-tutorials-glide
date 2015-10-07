package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExampleGlideModuleUnsafeOkHttp extends AppCompatActivity {

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

        loadImageViaUnsafeOkHttpPicassoInstance();
    }

    private void loadImageViaUnsafeOkHttpPicassoInstance() {

        Glide
                .with( context )
                .load( "unsafe https image" )
                .into(imageView4);


    }
}
