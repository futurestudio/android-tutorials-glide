package io.futurestud.tutorials.glide.ui.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import io.futurestud.tutorials.glide.ui.MenuContent;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                MenuContent.ITEMS));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {
            case 0:
                showExampleActivity(UsageExampleSimpleLoading.class);
                break;

            case 1:
                showExampleActivity(UsageExampleListViewAdapter.class);
                break;

            case 2:
                showExampleActivity(UsageExampleGridViewAdapter.class);
                break;

            case 3:
                showExampleActivity(UsageExamplePlaceholdersAndErrors.class);
                break;

            case 4:
                showExampleActivity(UsageExampleImageResizing.class);
                break;

            case 5:
                showExampleActivity(UsageExampleGifAndVideos.class);
                break;

            case 6:
                showExampleActivity(UsageExampleRequestPriority.class);
                break;

            case 7:
                showExampleActivity(UsageExampleTargetsAndRemoteViews.class);
                break;

            case 8:
                showExampleActivity(UsageExampleRotationTransformation.class);
                break;

            case 10:
                showExampleActivity(UsageExampleLoggingAndStats.class);
                break;

            case 11:
                showExampleActivity(UsageExampleGlideModuleUnsafeOkHttp.class);
                break;

            case 12:
                showExampleActivity(UsageExamplePicassoBuilderRequestHandler.class);
                break;

            default:
                Toast.makeText(MainActivity.this, "not yet implemented", Toast.LENGTH_SHORT).show();
        }
    }

    private void showExampleActivity(Class targetClass) {
        startActivity(new Intent(this, targetClass));
    }
}