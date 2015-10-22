package io.futurestud.tutorials.glide.glidemodule;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by norman on 10/17/15.
 */
public class CustomCachingGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat( DecodeFormat.PREFER_ARGB_8888 );

        // memory cache
        MemorySizeCalculator calculator = new MemorySizeCalculator( context );
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ) );
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ) );

        // disk cache
        // set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;

        builder.setDiskCache(
                new InternalCacheDiskCacheFactory( context, cacheSize100MegaBytes ) );

        builder.setDiskCache(
                new ExternalCacheDiskCacheFactory( context, cacheSize100MegaBytes ) );

        // set custom location
        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();

        builder.setDiskCache(
                new DiskLruCacheFactory( downloadDirectoryPath, cacheSize100MegaBytes ) );

        // In case you want to specify a cache folder ("glide"):
        //builder.setDiskCache(
        //        new DiskLruCacheFactory( downloadDirectoryPath, "glidecache", cacheSize100MegaBytes ) );

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // nothing to do here
    }
}