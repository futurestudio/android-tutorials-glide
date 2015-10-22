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
        glide.register(CustomImageSizeModel.class, InputStream.class, new CustomImageSizeModelFactory());
    }

    public static class CustomImageSizeUrlLoader extends BaseGlideUrlLoader<CustomImageSizeModel> {
        public CustomImageSizeUrlLoader(Context context) {
            super( context );
        }

        @Override
        protected String getUrl(CustomImageSizeModel model, int width, int height) {
            return model.requestCustomSizeUrl( width, height );
        }
    }

    // way 1: statically via GlideModule;
    private class CustomImageSizeModelFactory implements com.bumptech.glide.load.model.ModelLoaderFactory<CustomImageSizeModel, InputStream> {
        @Override
        public ModelLoader<CustomImageSizeModel, InputStream> build(Context context, GenericLoaderFactory factories) {
            return new CustomImageSizeUrlLoader( context );
        }

        @Override
        public void teardown() {

        }
    }

    // way 2: dynamically via using();
    public interface CustomImageSizeModel {
        String requestCustomSizeUrl(int width, int height);
    }

    public static class CustomImageSizeModelFutureStudio implements CustomImageSizeModel {

        String baseImageUrl;

        public CustomImageSizeModelFutureStudio(String baseImageUrl) {
            this.baseImageUrl = baseImageUrl;
        }

        @Override
        public String requestCustomSizeUrl(int width, int height) {
            // assumes the server understands the additional parameters of the image
            return baseImageUrl + "?w=" + width + "&h=" + height;
        }
    }
}
