package com.example.pneu_cov;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    public static Button dia_lang;
    public static Button next;
    public static boolean lang_selected = true;
    public static Context context;
    public String t = "o";
    public static Resources resources;
    public static final String[] language = {"English","हिंदी"};

    //public void lefttoright(View view){
      //  startActivity(new Intent(MainActivity.this, home.class));
        //customType(MainActivity.this,"left-to-right");
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dia_lang = (Button) findViewById(R.id.dia_lang);
        textview = (TextView) findViewById(R.id.textview);
        next = (Button) findViewById(R.id.next);

        dia_lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedItem;
                if (lang_selected) {
                    checkedItem = 0;
                } else {
                    checkedItem = 1;
                }

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Select a language")
                        .setSingleChoiceItems(language, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dia_lang.setText(language[which]);
                                if (language[which].equals("English")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "en");
                                    resources = context.getResources();
                                    textview.setText(context.getString(R.string.language));
                                    next.setText(context.getString(R.string.next));
                                    t = "EN";
                                }
                                if (language[which].equals("हिंदी")) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "hi");
                                    resources = context.getResources();
                                    textview.setText(resources.getString(R.string.language));
                                    next.setText(context.getString(R.string.next));
                                    t = "HI";
                                }
                                if (language[which] == null) {
                                    context = LocaleHelper.setLocale(MainActivity.this, "en");
                                    resources = context.getResources();
                                    textview.setText(context.getString(R.string.language));
                                    next.setText(context.getString(R.string.next));
                                    t = "-";
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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, home.class);
                intent.putExtra("t", t);
                startActivity(intent);
                customType(MainActivity.this,"left-to-right");
                finish();
            }
        });

    }
}