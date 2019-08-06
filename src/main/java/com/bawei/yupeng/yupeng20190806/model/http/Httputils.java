package com.bawei.yupeng.yupeng20190806.model.http;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.bawei.yupeng.yupeng20190806.view.interfaces.IMainView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Httputils {
    private static Httputils httputils;
    private Httputils(){

    }
    public static Httputils getHttputils(){
        if (httputils == null){
            return new Httputils();
        }
        return httputils;
    }
    public  String getstring(final String str, final IMainView.CallBackData callBackData){
        @SuppressLint("StaticFieldLeak") final AsyncTask<String,Void,Void> asyncTask = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... strings) {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(str);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GEt");
                    connection.setReadTimeout(5000);
                    connection.setConnectTimeout(5000);
                    int responseCode = connection.getResponseCode();
                    callBackData.getback(str);
                    if (responseCode == 200) {
                        InputStream stream = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                        StringBuffer buffer = new StringBuffer();
                        String str = "";
                        while ((str = reader.readLine()) != null) {
                            buffer.append(str);
                        }
                        reader.close();
                        connection.disconnect();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
            final IMainView.Succer succer = null;

        };
        return "";
    }
}
