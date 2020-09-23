package com.lenovo.smarttraffic.util;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CkyCoonUtil {
    public static String url = "";

    public static void doPost(String action, Object obj, Class clazz, Mycallback mycallback, int type) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json;charset=utf-8"), gson.toJson(obj));
        Request request = new Request.Builder().post(requestBody).url(url+action).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("IOException",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Log.d("data",s);
                Object o = gson.fromJson(s, clazz);
                mycallback.sendResult(o,type);
            }
        });
    }

    public interface Mycallback {
        void sendResult(Object obj, int type);
    }
}
