package com.example.moish.jastrowapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.google.android.vending.expansion.zipfile.APKExpansionSupport;
import com.google.android.vending.expansion.zipfile.ZipResourceFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by noah on 1/13/18.
 */

public class ExternalStrorageHandler {

    public static final int MAINVERSION = 100;
    public static final int PATCHVERSION = 0;

    public static ImageSource getImageSource(int page, Context context){
        String pageNumber = IntToString.toStringOfLengthX(page, 4);

        String fileName = "drawable/jastrow" + pageNumber + ".png";



        try {
            ZipResourceFile expansionFile = APKExpansionSupport.getAPKExpansionZipFile(context, MAINVERSION, PATCHVERSION);
            /*ZipResourceFile.ZipEntryRO[] entries = expansionFile.getAllEntries();
            for(ZipResourceFile.ZipEntryRO z : entries){
                Log.e("zs", z.toString());
                Log.e("zs", z.mFileName);
                Log.e("zs", z.mFile.getName());


            }*/
            InputStream iS = expansionFile.getInputStream(fileName);
            Bitmap bM = BitmapFactory.decodeStream(iS);
// Get an input stream for a known file inside the expansion file ZIPs
            return ImageSource.bitmap(bM);
        }catch(IOException e){
            return null;
        }


    }
}
