package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;


public class GlideExampleActivity extends AppCompatActivity {

    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @InjectView(R.id.standard_list_imageview1) ImageView imageView1;
    @InjectView(R.id.standard_list_imageview2) ImageView imageView2;
    @InjectView(R.id.standard_list_imageview3) ImageView imageView3;
    @InjectView(R.id.standard_list_imageview4) ImageView imageView4;
    @InjectView(R.id.standard_list_imageview5) ImageView imageView5;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.inject( this );
    }

}