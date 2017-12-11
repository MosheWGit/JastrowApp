package com.example.moish.jastrowapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewer extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);

        if(pdfView == null){
            pdfView = (PDFView) findViewById(R.id.pdfView);
        }
        pdfView.fromAsset("pg_0001.pdf");
        //ImageView jastrowPic = (ImageView) findViewById(R.id.jastrowImage);
        //jastrowPic.setImageResource(R.mipmap.jastrowimage);






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
}
