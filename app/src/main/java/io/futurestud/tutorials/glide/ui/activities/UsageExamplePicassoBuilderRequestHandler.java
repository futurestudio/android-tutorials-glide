package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;
import com.squareup.picasso.RequestHandler;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;

public class UsageExamplePicassoBuilderRequestHandler extends AppCompatActivity {

    @InjectView(R.id.standard_list_imageview1) ImageView imageView1;
    @InjectView(R.id.standard_list_imageview2) ImageView imageView2;
    @InjectView(R.id.standard_list_imageview3) ImageView imageView3;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        loadImageWithCustomRequestHandler();
    }

    private void loadImageWithCustomRequestHandler() {
        // create Picasso.Builder object
        Picasso.Builder picassoBuilder = new Picasso.Builder(context);

        // add our custom eat foody request handler (see below for full class)
        picassoBuilder.addRequestHandler(new EatFoodyRequestHandler());

        // Picasso.Builder creates the Picasso object to do the actual requests
        Picasso picasso = picassoBuilder.build();

        // example #1: regular HTTP Uri schema, which will not use our custom request handler
        picasso
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .into(imageView1);

        // example #2 & #3: custom eatfoody Uri schema, which will trigger our custom request handler
        picasso
                .load("eatfoody://cupcake")
                .into(imageView2);

        picasso
                .load("eatfoody://full_cake")
                .into(imageView3);
    }

    public class EatFoodyRequestHandler extends RequestHandler {
        private static final String EAT_FOODY_RECIPE_SCHEME = "eatfoody";

        @Override
        public boolean canHandleRequest(Request data) {
            return EAT_FOODY_RECIPE_SCHEME.equals(data.uri.getScheme());
        }

        @Override
        public Result load(Request request, int networkPolicy) throws IOException {
            // do whatever is necessary here to load the image
            // important: you can only return a Result object
            // the constructor takes either a Bitmap or InputStream object, nothing else!

            // get the key for the requested image
            // if the schema is "eatfoody://cupcake", it'd return "cupcake"
            String imageKey = request.uri.getHost();

            Bitmap bitmap;
            if (imageKey.contentEquals("cupcake")) {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cupcake);
            }
            else if (imageKey.contentEquals("full_cake")) {
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.full_cake);
            }
            else {
                // fallback image
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
            }

            // return the result with the bitmap and the source info
            return new Result(bitmap, Picasso.LoadedFrom.DISK);
        }
    }
}
