package io.futurestud.tutorials.glide.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import io.futurestud.tutorials.glide.R;

/**
 * Created by norman on 10/10/15.
 */
public class FSAppWidgetIntentReceiver extends BroadcastReceiver {

    private static int clickCount = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals( "pl.looksok.intent.action.CHANGE_PICTURE" )) {
            updateWidgetPictureAndButtonListener( context );
        }
    }

    private void updateWidgetPictureAndButtonListener(Context context) {
        RemoteViews remoteViews = new RemoteViews( context.getPackageName(), R.layout.custom_view_futurestudio );
        remoteViews.setImageViewResource( R.id.custom_view_image, getImageToSet() );

        //REMEMBER TO ALWAYS REFRESH YOUR BUTTON CLICK LISTENERS!!!
        //remoteViews.setOnClickPendingIntent( R.id.custom_view_image, FSAppWidgetProvider.buildButtonPendingIntent( context ) );

        FSAppWidgetProvider.pushWidgetUpdate( context.getApplicationContext(), remoteViews );
    }

    private int getImageToSet() {
        clickCount++;
        return clickCount % 2 == 0 ? R.drawable.cupcake : R.drawable.floorplan;
    }
}
