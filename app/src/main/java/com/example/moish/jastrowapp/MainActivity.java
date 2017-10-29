package com.example.moish.jastrowapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.flyingpenguins.app.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageView jastrowPic = (ImageView) findViewById(R.id.jastrowImage);
        //jastrowPic.setImageResource(R.mipmap.jastrowimage);



        final Button button = (Button) findViewById(R.id.searchButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                sendMessaage(v);
            }
        });


        //openPDF(page);


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

    public int jastrowSearch(String text){
        boolean isThere = isHebrew(text);
        //also make sure its not empty
        int retval = 0;
        if(isThere){
            retval = 2;
        }
        else{
            Toast t = new Toast(this);
            t.makeText(this,R.string.hebrewOnlyError, Toast.LENGTH_SHORT).show();

        }

        return retval;
    }

    /**
     *
     * @param text the text to be checked
     * @return true if the stirng only contains hebrew characters
     */
    public boolean isHebrew(String text){

        HebrewCheck hr = new HebrewCheck();
        return hr.Run(text);

    }

    public void sendMessaage(View view){
        EditText searchBox = (EditText) findViewById(R.id.searchBox);
        String searchQuery = searchBox.getText().toString();
        int page = jastrowSearch(searchQuery);
        Intent intent = new Intent(this, PDFViewer.class);
        intent.putExtra("Page",page);
        startActivity(intent);

    }

    /*openPDF(int page){

    }*/
}
