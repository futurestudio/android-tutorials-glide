package io.futurestud.tutorials.glide.ui.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;

public class UsageExampleTargetsAndRemoteViews extends ActionBarActivity {

    private static final int NOTIFICATION_ID = 34567;

    private Context context = this;
    private Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            // loading of the bitmap was a success
            // TODO do some action with the bitmap
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            // loading of the bitmap failed
            // TODO do some action/warning/error message
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        loadImageBitmapWithTarget();
        loadImageBitmapForCustomNotification();
    }

    private void loadImageBitmapWithTarget() {
        Picasso
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .into(target);
    }

    private void loadImageBitmapForCustomNotification() {
        // create RemoteViews
        final RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.remoteview_notification);

        remoteViews.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.future_studio_launcher);

        remoteViews.setTextViewText(R.id.remoteview_notification_headline, "Headline");
        remoteViews.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");

        remoteViews.setTextColor(R.id.remoteview_notification_headline, getResources().getColor(android.R.color.black));
        remoteViews.setTextColor(R.id.remoteview_notification_short_message, getResources().getColor(android.R.color.black));

        // build notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(UsageExampleTargetsAndRemoteViews.this)
                        .setSmallIcon(R.mipmap.future_studio_launcher)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setContent(remoteViews)
                        .setPriority(NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

        // set big content view for newer androids
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = remoteViews;
        }

        NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, notification);

        // load image with Picasso into the RemoteViews of the notification
        Picasso
                .with(UsageExampleTargetsAndRemoteViews.this)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .into(remoteViews, R.id.remoteview_notification_icon, NOTIFICATION_ID, notification);
    }

}
