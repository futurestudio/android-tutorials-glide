package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.ui.adapter.AdvancedImageListAdapter;

public class UsageExampleAdvancedAdapter extends AppCompatActivity {

    @Bind(R.id.usage_example_listview) ListView listView;

    public UsageExampleAdvancedAdapter() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_listview);
        ButterKnife.bind(this);

        listView.setAdapter(new AdvancedImageListAdapter(UsageExampleAdvancedAdapter.this, UsageExampleListViewAdapter.eatFoodyImages));
    }
}