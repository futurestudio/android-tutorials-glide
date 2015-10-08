package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

@Deprecated
public class UsageExampleRequestManagementWithTag extends AppCompatActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageViewResize;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewResizeCenterCrop;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewResizeCenterInside;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewResizeScaleDown;
    @InjectView(R.id.standard_list_imageview5) ImageView imageViewFit;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        // todo implement this
    }

    public void buyButtonClicked(View v) {
        // display ProgressDialog
        // ...

        // stop image requests
        Picasso
                .with(context)
                .cancelTag("ShoppingCart");

        // make 'buy'-request to server
        // ...
    }
}