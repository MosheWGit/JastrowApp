package com.example.moish.jastrowapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView jastrowPic = (ImageView) findViewById(R.id.jastrowImage);
        //jastrowPic.setImageResource(R.mipmap.jastrowimage);

        EditText searchBox = (EditText) findViewById(R.id.searchBox);
        String searchQuery = searchBox.getText().toString();
        jastrowSearch(searchQuery);


        /*File file = new File(Environment.getExternalStorageDirectory(),
                "Report.pdf");
        Uri path = Uri.fromFile(file);
        Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
        pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfOpenintent.setDataAndType(path, "application/pdf");
        try {
            startActivity(pdfOpenintent);
        }
        catch (ActivityNotFoundException e) {

        }*/


    }

    public void jastrowSearch(String text){
        confirmHebrew(text);
    }

    public void confirmHebrew(String text){

    }
}
