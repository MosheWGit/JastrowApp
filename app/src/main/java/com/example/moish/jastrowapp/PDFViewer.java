package com.example.moish.jastrowapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;


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
            pageNumber = savedInstanceState.getInt("pgNum");

        }
        else {
            pageNumber = getPageNumberFromIntent();
        }

        updateImage(pageNumber);



        setUpButtons();

    }

    private void updateImage(int pageNumber) {
        image.setImage(ExternalStrorageHandler.getImageSource(pageNumber, this));
    }

    private void setUpButtons() {
        left = (FloatingActionButton) findViewById(R.id.leftButton);
        right = (FloatingActionButton) findViewById(R.id.rightButton);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pageNumber < 1704) {
                    updateImage(++pageNumber);

                    Log.d("Floating", "right pressed");
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pageNumber > 1) {
                    updateImage(--pageNumber);

                    Log.d("Floating", "left pressed");
                }
            }
        });
    }





    private int getPageNumberFromIntent() {
        Intent i = getIntent();
        return (Integer) i.getExtras().get("Page");

    }



    @Override
    public void onSaveInstanceState(Bundle outState){

        outState.putInt("pgNum", pageNumber);
        super.onSaveInstanceState(outState);
    }
}
