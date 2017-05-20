/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.futurestud.tutorials.glide.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import io.futurestud.tutorials.glide.R;

import static android.graphics.Bitmap.createBitmap;
import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static android.graphics.Shader.TileMode.REPEAT;

public class GrayscaleTransformation extends BitmapTransformation {

    private Context context;

    public GrayscaleTransformation(Context context) {
        super(context);

        this.context = context;
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap result = createBitmap(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig());
        Bitmap noise = BitmapFactory.decodeResource(context.getResources(), R.drawable.noise);

        BitmapShader shader = new BitmapShader(noise, REPEAT, REPEAT);

        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(colorMatrix);

        Paint paint = new Paint(ANTI_ALIAS_FLAG);
        paint.setColorFilter(filter);

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(toTransform, 0, 0, paint);

        paint.setColorFilter(null);
        paint.setShader(shader);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));

        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), paint);

        toTransform.recycle();
        noise.recycle();

        return result;
    }

    @Override
    public String getId() {
        return "grayscaleTransformation()";
    }
}
