package io.futurestud.tutorials.glide.glidemodule;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.stream.BaseGlideUrlLoader;
import com.bumptech.glide.module.GlideModule;

import java.io.InputStream;

/**
 * Created by norman on 10/17/15.
 */
public class CustomImageSizeGlideModule implements GlideModule {
    @Override public void applyOptions(Context context, GlideBuilder builder) {
        // nothing to do here
    }

    @Override public void registerComponents(Context context, Glide glide) {
        // todo  change this to a factory
        glide.register(MyDataModel.class, InputStream.class, new MyUrlLoaderFactory());
    }

    // way 1: dynamically via using();
    public interface MyDataModel {
        String buildUrl(int width, int height);
    }

    public static class MyDataModelImpl implements CustomImageSizeGlideModule.MyDataModel {

        String baseImageUrl;

        public MyDataModelImpl(String baseImageUrl) {
            this.baseImageUrl = baseImageUrl;
        }

        @Override
        public String buildUrl(int width, int height) {
            return baseImageUrl + "?w=" + width + "&h=" + height;
        }
    }

    public static class MyUrlLoader extends BaseGlideUrlLoader<MyDataModel> {
        public MyUrlLoader(Context context) {
            super( context );
        }

        @Override
        protected String getUrl(MyDataModel model, int width, int height) {
            // Construct the url for the correct size here.
            return model.buildUrl(width, height);
        }
    }

    // way 2: statically via GlideModule;
    private class MyUrlLoaderFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<MyDataModel, InputStream> {
        @Override
        public ModelLoader<MyDataModel, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new MyUrlLoader( context );
        }

        @Override
        public void teardown() {

        }
    }
}
