package io.futurestud.tutorials.glide.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.futurestud.tutorials.glide.ui.activities.UsageExampleAdvancedAdapter;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleAnimate;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleCacheBasics;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleCustomImageSize;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleDownload;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleGifAndVideos;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleGridViewAdapter;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleImageResizing;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleListViewAdapter;
import io.futurestud.tutorials.glide.ui.activities.UsageExamplePlaceholders;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleRequestPriority;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleSimpleLoading;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleTargetsAndRemoteViews;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleThumbnails;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleTransformations;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class MenuContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem( "Simple Image Loading", UsageExampleSimpleLoading.class));
        addItem(new DummyItem( "Adapter Use - ListView", UsageExampleListViewAdapter.class));
        addItem(new DummyItem( "Adapter Use - GridView", UsageExampleGridViewAdapter.class));
        addItem(new DummyItem( "Adapter Use - Advanced", UsageExampleAdvancedAdapter.class));
        addItem(new DummyItem( "Placeholder, Error & Fading", UsageExamplePlaceholders.class));
        addItem(new DummyItem( "Image Resizing, Scaling", UsageExampleImageResizing.class));
        addItem(new DummyItem( "Gif & Local Videos", UsageExampleGifAndVideos.class));
        addItem(new DummyItem( "Glide Cache Basics", UsageExampleCacheBasics.class));
        addItem(new DummyItem( "Glide Priority", UsageExampleRequestPriority.class));
        addItem(new DummyItem( "Thumbnails", UsageExampleThumbnails.class));
        addItem(new DummyItem( "Callbacks, Targets & Notifications", UsageExampleTargetsAndRemoteViews.class));
        addItem(new DummyItem( "Transformation", UsageExampleTransformations.class));
        addItem(new DummyItem( "Animation", UsageExampleAnimate.class));
        addItem(new DummyItem( "Custom Image Size", UsageExampleCustomImageSize.class));
        addItem(new DummyItem( "Download Images", UsageExampleDownload.class));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public String content;
        public Class goalClass;

        public DummyItem(String content, Class goalClass) {
            this.id = id;
            this.content = content;
            this.goalClass = goalClass;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
