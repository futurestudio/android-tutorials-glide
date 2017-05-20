package io.futurestud.tutorials.glide.ui.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.NotificationTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.ViewTarget;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.ui.views.FutureStudioView;

public class UsageExampleTargetsAndRemoteViews extends GlideExampleActivity {

    private static final int NOTIFICATION_ID = 34567;

    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            // do something with the bitmap
            // for demonstration purposes, let's set it to an imageview
            imageView1.setImageBitmap( bitmap );
        }
    };

    private SimpleTarget target2 = new SimpleTarget<Bitmap>( 250, 250 ) {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            imageView2.setImageBitmap( bitmap );
        }
    };

    private ViewTarget<FutureStudioView, GlideDrawable> viewTarget;
    private NotificationTarget notificationTarget;

    @BindView(R.id.standard_list_imageview1) ImageView imageView1;
    @BindView(R.id.standard_list_imageview2) ImageView imageView2;
    @BindView(R.id.standard_list_imageview3) ImageView imageView3;
    @BindView(R.id.standard_list_imageview4) ImageView imageView4;
    @BindView(R.id.standard_list_imageview5) ImageView imageView5;
    @BindView(R.id.standard_list_custom_view) FutureStudioView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_standard_imageview );
        ButterKnife.bind( this );

        loadImageSimpleTarget();
        loadImageSimpleTargetApplicationContext();

        loadImageViewTarget();
        loadImageNotification();
    }

    private void loadImageSimpleTarget() {
        Glide
                .with( context ) // could be an issue!
                .load( eatFoodyImages[0] )
                .asBitmap()
                .into( target );
    }

    private void loadImageSimpleTargetApplicationContext() {
        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[1] )
                .asBitmap()
                .into( target2 );
    }

    private void loadImageViewTarget() {
        viewTarget = new ViewTarget<FutureStudioView, GlideDrawable>( customView ) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                this.view.setImage( resource.getCurrent() );
            }
        };

        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[2] )
                .into( viewTarget );
    }

    private void loadImageNotification() {
        // create RemoteViews
        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.remoteview_notification);

        remoteViews.setImageViewResource(R.id.remoteview_notification_icon, R.mipmap.future_studio_launcher);

        remoteViews.setTextViewText(R.id.remoteview_notification_headline, "Headline");
        remoteViews.setTextViewText(R.id.remoteview_notification_short_message, "Short Message");

        remoteViews.setTextColor(R.id.remoteview_notification_headline, context.getResources().getColor( android.R.color.black));
        remoteViews.setTextColor(R.id.remoteview_notification_short_message, context.getResources().getColor(android.R.color.black));

        // build notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.future_studio_launcher)
                        .setContentTitle("Content Title")
                        .setContentText("Content Text")
                        .setContent(remoteViews)
                        .setPriority( NotificationCompat.PRIORITY_MIN);

        final Notification notification = mBuilder.build();

        // set big content view for newer androids
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            notification.bigContentView = remoteViews;
        }

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, notification);

        notificationTarget = new NotificationTarget(
                context,
                remoteViews,
                R.id.remoteview_notification_icon,
                notification,
                NOTIFICATION_ID);

        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[3] )
                .asBitmap()
                .into( notificationTarget );
    }

    /*
    // todo remoteviews and notifications
    private void loadImageSimpleTargetApplicationContext() {
        Glide
                .with( context.getApplicationContext() ) // safer!
                .load( eatFoodyImages[0] )
                .asBitmap()
                .into( target2 );
    }
    */

    // todo todo add appwidgets
}
