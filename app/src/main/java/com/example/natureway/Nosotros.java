package com.example.natureway;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class Nosotros extends AppCompatActivity {

    private ImageButton facebook,telefono,instagram,web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Acerca de Arachnida Oficial");
        actionBar.setDisplayHomeAsUpEnabled(true);


        facebook = (ImageButton) findViewById(R.id.facebook);
        telefono = (ImageButton)findViewById(R.id.phone);
        instagram = (ImageButton) findViewById(R.id.instagram);
        web = (ImageButton)findViewById(R.id.web);

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebookId = "fb://page/arachnidamx";
                String urlPage = "http://www.facebook.com/arachnidamx";

                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(facebookId)));
                } catch (Exception e) {
                    //Abre url de pagina.
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlPage)));
                }
            }
        });

        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Phone = "2462001791";
                String NumPhone="tel:"+ Phone;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(NumPhone)));
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://instagram.com/_u/arachnida_mx/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.instagram.android");

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    //No encontró la aplicación, abre la versión web.
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/arachnida_mx/")));
                }
            }
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "www.arachnida.com.mx";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url));
                intentWeb.setAction(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse("http://" + url));
                startActivity(intentWeb);
            }
        });

    }
}