package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.ui.adapter.SimpleImageListAdapter;

public class UsageExampleListViewAdapter extends AppCompatActivity {

    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "",
            "http://i.imgur.com/C9pBVt7.jpg",
            "",
            "",
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

    @Bind(R.id.usage_example_listview) ListView listView;

    public UsageExampleListViewAdapter() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_listview);
        ButterKnife.bind(this);

        listView.setAdapter(new SimpleImageListAdapter(UsageExampleListViewAdapter.this, eatFoodyImages));
    }
}