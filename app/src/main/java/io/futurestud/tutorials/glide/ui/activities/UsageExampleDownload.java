package io.futurestud.tutorials.glide.ui.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;

import java.io.File;
import java.util.concurrent.ExecutionException;

public class UsageExampleDownload extends GlideExampleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(UsageExampleDownload.this, "No visual demo, check the source code :)", Toast.LENGTH_LONG).show();

        //downloadImage();
    }

    private void downloadImage() {
        FutureTarget<File> fileFutureTarget = Glide
                .with(context)
                .load(eatFoodyImages[0])
                .downloadOnly(500, 500);

        try {
            File file = fileFutureTarget.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
