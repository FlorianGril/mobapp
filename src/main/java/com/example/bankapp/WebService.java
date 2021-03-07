package com.example.bankapp;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.HttpURLConnection;

public class WebService {
    private static final String URL = getSecureBaseUrl();

    static {
        System.loadLibrary("nativelib");
    }

    public static native String baseUrlFromJNI();

    // decode base64 to a string and get normal url
    public static String getSecureBaseUrl() {
        String mUrl = baseUrlFromJNI();
        try {
            String text = new String(Base64.decode(mUrl, Base64.DEFAULT), "UTF-8");
            return text;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        mUrl = "https://60102f166c21e10017050128.mockapi.io/labbbank/accounts";
        return mUrl;
    }

    private static InputStream sendRequest(URL url) throws Exception {

        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return urlConnection.getInputStream();
            }
        } catch (Exception e) {
            throw new Exception("");
        }
        return null;
    }

    public static String getAccounts() {

        try {
            InputStream inputStream = sendRequest(new URL(URL));

            if(inputStream != null) {

                InputStreamReader reader = new InputStreamReader(inputStream);

                return reader.toString();
            }

        } catch (Exception e) {
            Log.e("WebService", "Impossible de rapatrier les données :(");
        }
        return null;
    }


}
