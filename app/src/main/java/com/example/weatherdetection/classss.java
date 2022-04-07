package com.example.weatherdetection;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.JsonToken;
import android.util.Log;

import com.example.weatherdetection.MainActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class classss {//extends AsyncTask<String,Void,String> {

  Context cc;


     ProgressDialog dillog;
    Handler handler=new Handler();



    public classss(Context cc) {
        this.cc = cc;
    }

    public void runn(String ssb) {
        dillog=new ProgressDialog(cc);
        dillog.setTitle("link connecting.");
        dillog.setMessage("wait a sec..");
        dillog.show();

        new Thread(new Runnable() {

            @Override
            public void run() {



        String ss = ssb;


        // @Override
        //protected void onPreExecute() {

        // }

        //  @Override
        //  protected String doInBackground(String... strings) {
        //   String ss=strings[0];
        InputStream inputStream;

        try {

            URL url = new URL(ss);
            HttpURLConnection myconn = (HttpURLConnection) url.openConnection();

            myconn.connect();
            inputStream = myconn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String li = " ";
            while ((li = br.readLine()) != null) {
                sb.append(li + " \n");
            }
            br.close();
            inputStream.close();
            //jason(sb.toString());
            Log.i("dsfddgf", "jason2");
            JSONObject jsonObj = new JSONObject(sb.toString());
            Log.i("dsfddgf", "jason3");
            JSONObject main = jsonObj.getJSONObject("current");
            Log.i("dsfddgf", "jason4");
            String tempMin = main.getString("temp_c") + "°C";
            String windspeed="Wind Speed: "+main.getString("wind_kph")+" kph";
            String pressure="Pressure: "+main.getString("pressure_mb")+" mb";
            String winddire="Wind Direction: "+main.getString("wind_dir");
            String humidity="Humidity: "+main.getString("humidity");
            Log.i("dsfddgf", "jason5");
            String tempMax = tempMin + " - " + main.getString("temp_f") + "°C";
            Log.i("dsfddgf", "jason6");
            //  return tempMax;

            //  Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
            // return  bitmap;
            Log.i("hghk", tempMax);
                 /*   new Thread(new Runnable() {
                        @Override
                        public void run() {*/
          // print(tempMax);
      handler.post(new Runnable() {
          @Override
          public void run() {
              dillog.hide();
              MainActivity.print.setText(tempMax);
              MainActivity.pressure.setText(pressure);
              MainActivity.humidity.setText(humidity);
              MainActivity.winds.setText(windspeed);
              MainActivity.windd.setText(winddire);


          }
      });
          //  MainActivity.print.setText(tempMax);
            // }
            //}).start();


            Log.i("hghk", tempMax);
            Log.i("dsfddgf", "runntry");

        } catch (Exception e) {
            Log.i("dsfddgf", "runnexcep");
            e.printStackTrace();
        }


            }
        }).start();


    }



  /*  public void jason(String sb){
        Log.i("dsfddgf", "jason1");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Log.i("dsfddgf", "jason2");
                    JSONObject jsonObj = new JSONObject(sb);
                    Log.i("dsfddgf", "jason3");
                    JSONObject main = jsonObj.getJSONObject("current");
                    Log.i("dsfddgf", "jason4");
                    String tempMin = main.getString("temp_c") + "°C";
                    Log.i("dsfddgf", "jason5");
                    String tempMax = tempMin + " - " + main.getString("temp_f") + "°C";
                    Log.i("dsfddgf", "jason6");
                    //  return tempMax;

                    //  Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
                    // return  bitmap;
                    Log.i("hghk", tempMax);
                   new Thread(new Runnable() {
                        @Override
                        public void run() {*/
                       /*   MainActivity.print.setText(tempMax);
                       // }
                    //}).start();


                    Log.i("hghk", tempMax);
                } catch (Exception e) {
                    Log.i("dsfddgf", "jasonexcep");
                    e.printStackTrace();
                }


            }
        }).start();

        }*/




}

