package com.lenovo.smarttraffic.util;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TestFutureUtil implements Callable<String> {
    Object req;
    String action;
    public static String url = "http://192.168.1.104:8080/transportservice/action/";
    public TestFutureUtil() {
    }

    public TestFutureUtil(Object req, String action) {
        this.req = req;
        this.action = action;
    }

    @Override
    public String call() throws Exception {

//        OkHttpUtil.doPost();
        //耗时

        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(MediaType.get("application/json;charset=UTF-8"), gson.toJson(req));
        Request request = new Request.Builder()
                .url(url + action)
                .post(body)
                .build();
        Response rep = client.newCall(request).execute();

        return rep.body().string();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String resultStr = response.body().string();
//                Object o = gson.fromJson(resultStr, tClass);
//                myCallBack.sendResult(o, typeId);
//            }
//        });
//        return null;
    }

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("UserName","user1");
        TestFutureUtil g1 = new TestFutureUtil(hashMap,"GetAllCarPeccancy.do");
        TestFutureUtil g2 = new TestFutureUtil(hashMap,"GetCarParkInfo.do");

        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<String> future1 = executor.submit(g1);
        Future<String> future2 = executor.submit(g2);
        try {
            String x = future1.get();
            String y = future2.get();
            //合并
            System.out.println("main: " + x + y);
//            Log.e("sb", "main: " + x + y );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
