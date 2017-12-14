package com.example.moish.jastrowapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


import java.io.File;

public class PDFViewer extends AppCompatActivity {

    SubsamplingScaleImageView image;
    ImageSource imageSource;
    int resId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        if(image == null){
            image = (SubsamplingScaleImageView) findViewById(R.id.pdfView);
        }

        if(savedInstanceState != null){
            resId = savedInstanceState.getInt("resId");
            imageSource = ImageSource.resource(resId);
        }
        else {
            setImageSource();
        }


        image.setImage(imageSource);

    }


    private void setImageSource() {
        Intent i = getIntent();
        int page = (Integer) i.getExtras().get("Page");
        String pageNumber = IntToString.toStringOfLengthX(page, 4);

        String fileName = "jastrow" + pageNumber;
        Resources r = getResources();
        resId = r.getIdentifier(fileName, "drawable", getApplication().getPackageName());


        imageSource = ImageSource.resource(resId);
        if(imageSource == null){
            Log.e("pdf", "imagesource came back null. consider chekcing asset name");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putInt("resId", resId);

        super.onSaveInstanceState(outState);
    }
}
