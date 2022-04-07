package com.example.weatherdetection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText input;
   static TextView print,humidity,pressure,winds,windd;
   TextView city;
    ConnectivityManager cman;
    NetworkInfo ninfo;
    ImageView search;




    classss cl;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input=(EditText)findViewById(R.id.inputtext);
        print=(TextView)findViewById(R.id.print);
        city=(TextView)findViewById(R.id.city);
        humidity=(TextView)findViewById(R.id.humidity);
        pressure=(TextView)findViewById(R.id.pressure);
        windd=(TextView)findViewById(R.id.windd);
        winds=(TextView)findViewById(R.id.winds);
        search=(ImageView)findViewById(R.id.search);

       // search.setBackground(R.drawable.backserch);



        cman=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        ninfo=cman.getActiveNetworkInfo();





        String st="http://api.weatherapi.com/v1/current.json?key= f6ad9712aafc496c8d8145010221403&aqi=no&q=";


        cl = new classss(this);




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setVisibility(v.VISIBLE);
                search.setVisibility(v.INVISIBLE);
            }
        });


       input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences sh=getSharedPreferences("cityname",MODE_PRIVATE);
                SharedPreferences.Editor editor=sh.edit();
                editor.putString("name",input.getText().toString());
                editor.commit();

                InputMethodManager im=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                im.hideSoftInputFromWindow(v.getWindowToken(),0);

                String et=(input.getText()).toString();
                String ssb=st.concat(et);
                city.setText(et);
                input.setVisibility(v.INVISIBLE);
                search.setVisibility(v.VISIBLE);

               if(ninfo!=null && ninfo.isConnected()) {
                   Log.i("execute A", " "+et);
                   Log.i("execute A", " "+ssb);
                   if(et!=null)
                  cl.runn(ssb);
               }







            }
        });



    }

  /*  @Override
    protected void onStart() {
        super.onStart();
       if(input.getText().toString()!=null) {
           SharedPreferences sh = getSharedPreferences("cityname", MODE_PRIVATE);
           String string = sh.getString("name", "");
           search.setVisibility(View.VISIBLE);
           input.setVisibility(View.INVISIBLE);

           String et = (input.getText()).toString();
           String ssb = string.concat(et);
           city.setText(et);


           if (ninfo != null && ninfo.isConnected()) {
               if (et != null) ;
               // cl.runn(ssb);
           }
       }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh=getSharedPreferences("cityname",MODE_PRIVATE);
        SharedPreferences.Editor editor=sh.edit();
        editor.putString("name",input.getText().toString());
        editor.commit();
    }*/

}