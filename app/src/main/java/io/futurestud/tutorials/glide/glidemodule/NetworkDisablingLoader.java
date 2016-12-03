package io.futurestud.tutorials.glide.glidemodule;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.IOException;
import java.io.InputStream;

import io.futurestud.tutorials.glide.ui.activities.UsageExampleGlideUrl;

/**
 * Created by norman on 12/3/16.
 */

public class NetworkDisablingLoader implements StreamModelLoader<UsageExampleGlideUrl.GlideUrlWithQueryParameter> {
    @Override public DataFetcher<InputStream> getResourceFetcher(final UsageExampleGlideUrl.GlideUrlWithQueryParameter model, int width, int height) {
        return new DataFetcher<InputStream>() {
            @Override public InputStream loadData(Priority priority) throws Exception {
                throw new IOException("Forced Glide network failure");
            }
            @Override public void cleanup() { }
            @Override public String getId() { return model.getCacheKey(); }
            @Override public void cancel() { }
        };
    }
}