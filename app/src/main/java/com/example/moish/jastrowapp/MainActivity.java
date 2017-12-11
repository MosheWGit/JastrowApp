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

    private HebrewCheck hebrewCheck;
    private BSForJPDF pageFinder;
    Button button;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPage("גע"); //this warms up the page finder

        setUpButton();
    }

    private void setUpButton(){
        if(button == null) {
            button = (Button) findViewById(R.id.searchButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    if(text == null){
                        text = (EditText) findViewById(R.id.searchBox);
                    }
                    presentPDF(text.getText().toString());
                }
            });
        }

    }

    /**
     *
     * @param text
     * @return the page number
     */
    private int getPage(String text){
        //TODO also make sure its not empty
        if(isHebrew(text)){
            if(pageFinder == null){
                pageFinder = new BSForJPDF();
            }
            return pageFinder.search(text);
        }
        else {


            return -1;
        }
    }

    /**
     *
     * @param text the text to be checked
     * @return true if the stirng only contains hebrew characters
     */
    public boolean isHebrew(String text){

        if(hebrewCheck == null){
            hebrewCheck = new HebrewCheck();
        }
        return hebrewCheck.isBasicHebrewCharacters(text);

    }

    private void presentPDF(String keyword){
        int page = getPage(keyword);
        if(page<0){
            Toast t = new Toast(this);
            t.makeText(this, R.string.hebrewOnlyError, Toast.LENGTH_SHORT).show();
        }
        else {
            Toast t = new Toast(this);
            t.makeText(this, "" + page, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PDFViewer.class);
            intent.putExtra("Page", page);
            startActivity(intent);
        }

    }

    /*openPDF(int page){

    }*/
}
