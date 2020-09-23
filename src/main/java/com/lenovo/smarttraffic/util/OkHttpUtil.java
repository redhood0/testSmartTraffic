package com.lenovo.smarttraffic.util;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtil {

    public static String url = "http://10.0.1.5:8080/transportservice/action/";
    public static String url2 = "http://server.xsy-io.com:7080/transportservice/action/";

    public static void doGet() {
        //OkHttpClient client = new OkHttpClient.Builder().build();
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public static void doPost2(String action, Object obj, Class clazz, MyCallBack myCallBack, int type) {
        OkHttpClient okHttpClient = new OkHttpClient();

        Gson gson = new Gson();
        RequestBody req = RequestBody.create(MediaType.get("application/json;charset=UTF-8"), gson.toJson(obj));
        Request request = new Request.Builder()
                .url(url + action)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("ss", "onFailure: " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Object obj = gson.fromJson(str, clazz);

                myCallBack.sendResult(obj, type);

            }
        });

    }


    public static void doPost(String action, Object req, Class tClass, MyCallBack myCallBack, int typeId) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(MediaType.get("application/json;charset=UTF-8"), gson.toJson(req));
        Request request = new Request.Builder()
                .url(url2 + action)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String resultStr = response.body().string();
                Object o = gson.fromJson(resultStr, tClass);
                myCallBack.sendResult(o, typeId);
            }

        });

    }

    public static void doPost2(String action,String req,Class clazz,MyCallBack myCallBack,int type){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(MediaType.get("application/json;charset=utf-8"),gson.toJson(req));
        Request request =new Request.Builder()
                .url(url+action)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String x =  response.body().string();
                myCallBack.sendResult(gson.fromJson(x,clazz),type);
            }
        });
    }

    public static void doPost3(String action,String req,Class clazz,MyCallBack myCallBack , int type){
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(MediaType.get("application/json;charset=utf-8"),gson.toJson(req));
        Request request =  new Request.Builder().url(url+action).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String x =  response.body().string();
               myCallBack.sendResult(gson.fromJson(x,clazz),type);
            }
        });
    }


}
