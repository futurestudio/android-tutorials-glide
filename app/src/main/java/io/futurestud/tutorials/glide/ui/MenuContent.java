package io.futurestud.tutorials.glide.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.futurestud.tutorials.glide.ui.activities.UsageExampleCacheBasics;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleGifAndVideos;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleGridViewAdapter;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleImageResizing;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleListViewAdapter;
import io.futurestud.tutorials.glide.ui.activities.UsageExamplePicassoBuilderRequestHandler;
import io.futurestud.tutorials.glide.ui.activities.UsageExamplePlaceholdersAndErrors;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleRequestPriority;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleSimpleLoading;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleTargetsAndRemoteViews;
import io.futurestud.tutorials.glide.ui.activities.UsageExampleThumbnails;

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
        addItem(new DummyItem("0", "Simple Image Loading", UsageExampleSimpleLoading.class));
        addItem(new DummyItem("1", "Adapter Use - ListView", UsageExampleListViewAdapter.class));
        addItem(new DummyItem("2", "Adapter Use - GridView", UsageExampleGridViewAdapter.class));
        addItem(new DummyItem("3", "Placeholder, Error & Fading", UsageExamplePlaceholdersAndErrors.class));
        addItem(new DummyItem("4", "Image Resizing, Scaling", UsageExampleImageResizing.class));
        addItem(new DummyItem("5", "Gif & Local Videos", UsageExampleGifAndVideos.class));
        addItem(new DummyItem("6", "Glide Cache Basics", UsageExampleCacheBasics.class));
        addItem(new DummyItem("7", "Glide Priority", UsageExampleRequestPriority.class));
        addItem(new DummyItem("8", "Thumbnails", UsageExampleThumbnails.class));
        addItem(new DummyItem("8", "Callbacks, Targets & Notifications", UsageExampleTargetsAndRemoteViews.class));

        addItem(new DummyItem("9", "Rotation and Transformation", UsageExamplePicassoBuilderRequestHandler.class));
        addItem(new DummyItem("10", "Influencing Image Caching", UsageExamplePicassoBuilderRequestHandler.class));
        addItem(new DummyItem("11", "Cache Indicators, Logging & Stats", UsageExamplePicassoBuilderRequestHandler.class));
        addItem(new DummyItem("12", "Picasso.Builder Basics", UsageExamplePicassoBuilderRequestHandler.class));
        addItem(new DummyItem("13", "Custom Request Handlers", UsageExamplePicassoBuilderRequestHandler.class));
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

        public DummyItem(String id, String content, Class goalClass) {
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
