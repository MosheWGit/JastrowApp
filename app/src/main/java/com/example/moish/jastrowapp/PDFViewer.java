package com.example.moish.jastrowapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


import java.io.File;

public class PDFViewer extends AppCompatActivity {

    private SubsamplingScaleImageView image;
    private ImageSource imageSource;
    private int resId;
    private int pageNumber;
    private FloatingActionButton right;
    private FloatingActionButton left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        if(image == null){
            image = (SubsamplingScaleImageView) findViewById(R.id.pdfView);
        }

        if(savedInstanceState != null){
            resId = savedInstanceState.getInt("resId");
            updateImageBasedOnResId();
        }
        else {
            setImageSource();
        }


        image.setImage(imageSource);
        setUpButtons();

    }

    private void setUpButtons() {
        left = (FloatingActionButton) findViewById(R.id.leftButton);
        right = (FloatingActionButton) findViewById(R.id.rightButton);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pageNumber < 1704) {
                    updateResID(pageNumber++);
                    updateImageBasedOnResId();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pageNumber > 1) {
                    updateResID(pageNumber--);
                    updateImageBasedOnResId();
                }
            }
        });
    }

    private void updateImageBasedOnResId() {
        imageSource = ImageSource.resource(resId);
    }

    private void updateResID(int page) {
        String pageNumber = IntToString.toStringOfLengthX(page, 4);

        String fileName = "jastrow" + pageNumber;
        Resources r = getResources();
        resId = r.getIdentifier(fileName, "drawable", getApplication().getPackageName());

    }


    private void setImageSource() {
        Intent i = getIntent();
        pageNumber = (Integer) i.getExtras().get("Page");
        updateResID(pageNumber);


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
