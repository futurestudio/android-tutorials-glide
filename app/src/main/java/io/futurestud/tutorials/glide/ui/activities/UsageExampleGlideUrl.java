package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleGlideUrl extends AppCompatActivity {

    @BindView(R.id.standard_list_imageview1) ImageView imageView1;
    @BindView(R.id.standard_list_imageview3) ImageView imageView2;
    @BindView(R.id.standard_list_imageview4) ImageView imageView3;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.bind(this);

        loadFirst();
    }

    private void loadFirst() {
        Glide
                .with(context)
                .load(new GlideUrlWithQueryParameter("http://placehold.it/500x500", "access", "mysecrettoken"))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .listener(new RequestListener<GlideUrlWithQueryParameter, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, GlideUrlWithQueryParameter model, Target<GlideDrawable> target, boolean isFirstResource) {
                        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, GlideUrlWithQueryParameter model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        loadSecond();
                        loadThird();
                        return false;
                    }
                })
                .into(imageView1);
    }

    // this photo should be loaded, since only the token is different
    private void loadSecond() {
        Toast.makeText(context, "loading 2", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("source", "feed");
        queryParams.put("access", "mysecrettoken");

        Glide
                .with(context)
                //.using(new NetworkDisablingLoader())
                .load(new GlideUrlWithQueryParameter("http://placehold.it/500x500", queryParams))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView2);
    }

    // this photo should not be loaded, since the base part of the URL is different (in this case different size)
    private void loadThird() {
        Toast.makeText(context, "loading 3", Toast.LENGTH_SHORT).show();

        Glide
                .with(context)
                //.using(new NetworkDisablingLoader())
                .load(new GlideUrlWithQueryParameter("http://placehold.it/400x400", "access", "mysecrettoken"))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView3);
    }

    public static class GlideUrlWithQueryParameter extends GlideUrl {
        private String mSourceUrl;

        public GlideUrlWithQueryParameter(String baseUrl, String key, String value) {
            super(buildUrl(baseUrl, key, value));

            mSourceUrl = baseUrl;
        }

        public GlideUrlWithQueryParameter(String baseUrl, Map<String, Object> queryParams) {
            super(buildUrl(baseUrl, queryParams));

            mSourceUrl = baseUrl;
        }

        private static String buildUrl(String baseUrl, String key, String value) {
            StringBuilder stringBuilder = new StringBuilder(baseUrl);

            if (stringBuilder.toString().contains("?")) {
                stringBuilder.append("&");
            }
            else {
                stringBuilder.append("?");
            }

            stringBuilder.append(key);
            stringBuilder.append("=");
            stringBuilder.append(value);

            return stringBuilder.toString();
        }

        private static String buildUrl(String baseUrl, Map<String, Object> queryParams) {
            StringBuilder stringBuilder = new StringBuilder(baseUrl);

            for (Map.Entry<String, Object> entry : queryParams.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (stringBuilder.toString().contains("?")) {
                    stringBuilder.append("&");
                }
                else {
                    stringBuilder.append("?");
                }

                stringBuilder.append(key);
                stringBuilder.append("=");
                stringBuilder.append(value);
            }

            return stringBuilder.toString();
        }

        @Override
        public String getCacheKey() {
            return mSourceUrl;
        }

        @Override
        public String toString() {
            return super.getCacheKey();
        }
    }

}