package com.example.pneu_cov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Result extends AppCompatActivity {
    public Context context;
    public static Resources resources;
    public TextView result;
    public ImageView im;
    public TextView l;
    public TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        im = findViewById(R.id.im);
        result = findViewById(R.id.result);
        l = findViewById(R.id.l);
        test2 = findViewById(R.id.test2);
        Intent intent = getIntent();
        String res = intent.getExtras().getString("res");
        if(res.equals("1")){
            String o = intent.getExtras().getString("o");
            if(o.equals("EN")){
                context = LocaleHelper.setLocale(Result.this, "en");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("You have selected this Image");
                result.setText("Normal Case");
            }
            else if(o.equals("HI")){
                context = LocaleHelper.setLocale(Result.this, "hi");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("आपने इस छवि को चुना है");
                result.setText("परिणाम ठीक है");
            }
            else{
                context = LocaleHelper.setLocale(Result.this, "en");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("You have selected this Image");
                result.setText("Normal Case");
            }

            //Intent intent = getIntent();
            if(getIntent().hasExtra("byteArray")) {
                //ImageView previewThumbnail = new ImageView(this);
                Bitmap b = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
                im.setImageBitmap(b);
            }
        }
        else if(res.equals("0")){
            String o = intent.getExtras().getString("o");
            if(o.equals("EN")){
                context = LocaleHelper.setLocale(Result.this, "en");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("You have selected this Image");
                result.setText("Pneumonia Detected");
            }
            else if(o.equals("HI")){
                context = LocaleHelper.setLocale(Result.this, "hi");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("आपने इस छवि को चुना है");
                result.setText("निमोनिया है");
            }
            else{
                context = LocaleHelper.setLocale(Result.this, "en");
                resources = context.getResources();
                test2.setText(resources.getString(R.string.test));
                l.setText("You have selected this Image");
                result.setText("Pneumonia Detected");
            }
            //Intent intent1 = getIntent();
            if(getIntent().hasExtra("byteArray")) {
                Bitmap c = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
                im.setImageBitmap(c);
            }
        }
        else{
            result.setText("NOTHING SELECTED");
        }

    }
}