package io.futurestud.tutorials.glide.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        addItem(new DummyItem("0", "Simple Image Loading"));
        addItem(new DummyItem("1", "Adapter Use - ListView"));
        addItem(new DummyItem("2", "Adapter Use - GridView"));
        addItem(new DummyItem("3", "Placeholder, Error & Fading"));
        addItem(new DummyItem("4", "Image Resizing, Cropping and fit()"));
        addItem(new DummyItem("5", "Picasso Priority"));
        addItem(new DummyItem("6", "Callbacks, RemoteViews & Notifications"));
        addItem(new DummyItem("7", "Rotation and Transformation"));
        addItem(new DummyItem("8", "Influencing Image Caching"));
        addItem(new DummyItem("9", "Cache Indicators, Logging & Stats"));
        addItem(new DummyItem("10", "Picasso.Builder Basics"));
        addItem(new DummyItem("11", "Custom Request Handlers"));
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

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
