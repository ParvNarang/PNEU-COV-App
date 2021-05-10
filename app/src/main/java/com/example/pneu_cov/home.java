package com.example.pneu_cov;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pneu_cov.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static maes.tech.intentanim.CustomIntent.customType;

public class home extends AppCompatActivity {

    //private TextView textView;
    public Context context;
    public static Resources resources;
    public TextView cs,xr,test,info;
    public Button upload,sel;
    public ImageView lanch;
    public ImageView im;
    public String res;
    public static final String[] language = {"English","हिंदी"};
    public static boolean lang_selected = true;
    public Bitmap img;
    public static String o = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        xr = (TextView)findViewById(R.id.xr);
        cs = (TextView)findViewById(R.id.cs);
        test = (TextView)findViewById(R.id.test);
        info = (TextView)findViewById(R.id.info);
        upload = (Button)findViewById(R.id.upload);
        sel = (Button)findViewById(R.id.sel);
        lanch = (ImageView)findViewById(R.id.langch);
        im = (ImageView)findViewById(R.id.im);

        Intent intent = getIntent();
        String t = intent.getExtras().getString("t");

        if(t.equals("EN")){
            context = LocaleHelper.setLocale(home.this,"en");
            resources = context.getResources();
            xr.setText(resources.getString(R.string.g));
            cs.setText(resources.getString(R.string.h));
            info.setText(resources.getString(R.string.info));
            test.setText(resources.getString(R.string.test));
            upload.setText(resources.getString(R.string.upload));
            sel.setText(resources.getString(R.string.select));
            o = "EN";
        }
        if(t.equals("HI")){
            context = LocaleHelper.setLocale(home.this,"hi");
            resources = context.getResources();
            xr.setText(resources.getString(R.string.g));
            cs.setText(resources.getString(R.string.h));
            info.setText(resources.getString(R.string.info));
            test.setText(resources.getString(R.string.test));
            upload.setText(resources.getString(R.string.upload));
            sel.setText(resources.getString(R.string.select));
            o = "HI";
        }
        if(t.equals("-")){
            context = LocaleHelper.setLocale(home.this,"en");
            resources = context.getResources();
            xr.setText(resources.getString(R.string.g));
            cs.setText(resources.getString(R.string.h));
            info.setText(resources.getString(R.string.info));
            test.setText(resources.getString(R.string.test));
            upload.setText(resources.getString(R.string.upload));
            sel.setText(resources.getString(R.string.select));
            o = "EN";
        }
        lanch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedItem;
                if(lang_selected){
                    checkedItem = 0;
                }
                else{
                    checkedItem = 1;
                }

                final AlertDialog.Builder builder = new AlertDialog.Builder(home.this);

                builder.setTitle("Select a language")
                        .setSingleChoiceItems(language, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(language[which].equals("English")){
                                    context = LocaleHelper.setLocale(home.this,"en");
                                    resources = context.getResources();
                                    xr.setText(resources.getString(R.string.g));
                                    cs.setText(resources.getString(R.string.h));
                                    info.setText(resources.getString(R.string.info));
                                    test.setText(resources.getString(R.string.test));
                                    upload.setText(resources.getString(R.string.upload));
                                    sel.setText(resources.getString(R.string.select));
                                    o = "EN";
                                }
                                else if(language[which].equals("हिंदी")){
                                    context = LocaleHelper.setLocale(home.this,"hi");
                                    resources = context.getResources();
                                    xr.setText(resources.getString(R.string.g));
                                    cs.setText(resources.getString(R.string.h));
                                    info.setText(resources.getString(R.string.info));
                                    test.setText(resources.getString(R.string.test));
                                    upload.setText(resources.getString(R.string.upload));
                                    sel.setText(resources.getString(R.string.select));
                                    o = "HI";
                                }
                                else{
                                    context = LocaleHelper.setLocale(home.this,"en");
                                    resources = context.getResources();
                                    xr.setText(resources.getString(R.string.g));
                                    cs.setText(resources.getString(R.string.h));
                                    info.setText(resources.getString(R.string.info));
                                    test.setText(resources.getString(R.string.test));
                                    upload.setText(resources.getString(R.string.upload));
                                    sel.setText(resources.getString(R.string.select));
                                    o = "EN";
                                }
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                builder.create().show();
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            }
        });
        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img = Bitmap.createScaledBitmap(img, 224,224,true);
                try {
                    Model model = Model.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);

                    TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                    tensorImage.load(img);
                    ByteBuffer byteBuffer = tensorImage.getBuffer();

                    inputFeature0.loadBuffer(byteBuffer);
                    // Runs model inference and gets result.
                    Model.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    // Releases model resources if no longer used.
                    model.close();

                    //tv.setText(outputFeature0.getFloatArray()[0] + "\n"+outputFeature0.getFloatArray()[1]);
                    if(outputFeature0.getFloatArray()[0]==1){
                        res = "1";
                        Intent intent = new Intent(home.this,Result.class);
                        intent.putExtra("res",res);
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        img.compress(Bitmap.CompressFormat.PNG, 30, bs);
                        intent.putExtra("byteArray", bs.toByteArray());
                        intent.putExtra("o",o);
                        startActivity(intent);
                        customType(home.this,"left-to-right");
                    }
                    if(outputFeature0.getFloatArray()[1]==1){
                        res = "0";
                        Intent intent = new Intent(home.this,Result.class);
                        intent.putExtra("res",res);
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        img.compress(Bitmap.CompressFormat.PNG, 30, bs);
                        intent.putExtra("byteArray", bs.toByteArray());
                        intent.putExtra("o",o);
                        startActivity(intent);
                        customType(home.this,"left-to-right");
                    }

                } catch (IOException e) {
                    // TODO Handle the exception

                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100)
        {
            im.setImageURI(data.getData());

            Uri uri = data.getData();
            try {
                img = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                //                super.onBackPressed();
                //                finish();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //public void onBackPressed() {
      //      super.onBackPressed();
    //}
}