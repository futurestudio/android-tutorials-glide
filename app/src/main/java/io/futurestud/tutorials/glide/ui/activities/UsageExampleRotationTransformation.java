package io.futurestud.tutorials.glide.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.futurestud.tutorials.glide.R;
import io.futurestud.tutorials.glide.transformation.BlurTransformation;
import io.futurestud.tutorials.glide.transformation.GrayscaleTransformation;

public class UsageExampleRotationTransformation extends ActionBarActivity {


    @InjectView(R.id.standard_list_imageview1) ImageView imageViewSimpleRotate;
    @InjectView(R.id.standard_list_imageview2) ImageView imageViewComplexRotate;
    @InjectView(R.id.standard_list_imageview3) ImageView imageViewTransformationBlur;
    @InjectView(R.id.standard_list_imageview4) ImageView imageViewTransformationsMultiple;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.inject(this);

        loadImageWithSimpleRotate();
        loadImageWithComplexRotate();
        loadImageWithTransformation();
        loadImageWithMultipleTransformation();
    }

    private void loadImageWithSimpleRotate() {
        Picasso
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .rotate(90f)
                .into(imageViewSimpleRotate);
    }

    private void loadImageWithComplexRotate() {
        Picasso
                .with(context)
                .load(R.drawable.floorplan)
                .rotate(45f, 200f, 100f)
                .into(imageViewComplexRotate);
    }

    private void loadImageWithTransformation() {
        Picasso
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                        //.transform(new GrayscaleTransformation(Picasso.with(context)))
                .transform(new BlurTransformation(context))
                .into(imageViewTransformationBlur);
    }

    private void loadImageWithMultipleTransformation() {
        List<Transformation> transformations = new ArrayList<>();

        transformations.add(new GrayscaleTransformation(Picasso.with(context)));
        transformations.add(new BlurTransformation(context));

        Picasso
                .with(context)
                .load(UsageExampleListViewAdapter.eatFoodyImages[0])
                .transform(transformations)
                .into(imageViewTransformationsMultiple);
    }
}
