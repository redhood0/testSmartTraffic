package com.lenovo.smarttraffic.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp3 {
    static String url = "xxx.xxx.xxx/";

    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final Pattern TYPE_SUBTYPE = Pattern.compile(TOKEN + "/" + TOKEN);
    private static final Pattern PARAMETER = Pattern.compile(
            ";\\s*(?:" + TOKEN + "=(?:" + TOKEN + "|" + QUOTED + "))?");

    static void doPost(String post, Object req, MyCallBack callBack, int type) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Gson gson = new Gson();


        RequestBody requestBody = RequestBody.create(MediaType.get("application/json;charset=utf-8"), gson.toJson(req));//不然中文会失效

        Request request = new Request.Builder().url(url + post)
                .post(requestBody)
                .build();

        builder.build().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callBack.sendResult(request, type);
            }
        });
    }

    public static void dopost2(String post,Object req,MyCallBack myCallBack,int type,Class c){
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson  = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.get("application/json;charset=utf-8"),gson.toJson(req));

        Request request = new  Request.Builder().url(url+post)
                .post(requestBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
               Object o =  gson.fromJson(response.message(),c);
                myCallBack.sendResult(o,type);
            }
        });
    }

    static void sb(String string) {
        Matcher typeSubtype = TYPE_SUBTYPE.matcher(string);
        if (!typeSubtype.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + string + '"');
        }
        String type = typeSubtype.group(1).toLowerCase(Locale.US);
        String subtype = typeSubtype.group(2).toLowerCase(Locale.US);
        System.out.println("PARAMETER.matcher(string)>>>"+type +">>>" +subtype+">>>" +typeSubtype.group(0) + ">>>" +typeSubtype.end());
        String charset = null;
        Matcher parameter = PARAMETER.matcher(string);
//        System.out.println("PARAMETER.matcher(string)>>>"+parameter.start() );
//        System.out.println("PARAMETER.matcher(string)>>>"+parameter.end() );

        //System.out.println("typeSubtype.end()>>>"+typeSubtype.end()+">>>parameter.end()>>>" +parameter.end() );

        for (int s = typeSubtype.end(); s < string.length(); s = parameter.end()) {


            parameter.region(s, string.length());

            System.out.println(" parameter.region(s, string.length());>>>"+s+">>>"+string.length());
            if (!parameter.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \""
                        + string.substring(s)
                        + "\" for: \""
                        + string
                        + '"');
            }



            String name = parameter.group(1);
            System.out.println("parameter.group(1)>>>"+name);
            if (name == null || !name.equalsIgnoreCase("charset")) continue;
            String charsetParameter;
            String token = parameter.group(2);
            System.out.println("parameter.group(2)>>>"+token);

            if (token != null) {
                // If the token is 'single-quoted' it's invalid! But we're lenient and strip the quotes.
                charsetParameter = (token.startsWith("'") && token.endsWith("'") && token.length() > 2)
                        ? token.substring(1, token.length() - 1)
                        : token;
            } else {
                // Value is "double-quoted". That's valid and our regex group already strips the quotes.
                charsetParameter = parameter.group(3);
                System.out.println("parameter.group(3)>>>"+charsetParameter);

            }
            if (charset != null && !charsetParameter.equalsIgnoreCase(charset)) {
                throw new IllegalArgumentException("Multiple charsets defined: \""
                        + charset
                        + "\" and: \""
                        + charsetParameter
                        + "\" for: \""
                        + string
                        + '"');
            }
            charset = charsetParameter;

            System.out.println("parameter.group(3)>>>"+parameter.end());
        }
    }

    public static void main(String[] args) {
        sb("application/json;charset=\"uu\"");

        float xx = 0.012321f;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
      String x =   decimalFormat.format(xx);
        System.out.println(x);
//        System.out.println("\"ssss\"");

    }
    public void dopost3(String action,Object req,Class c,MyCallBack myCallBack,int type){
        Gson gson = new Gson();
        RequestBody requestBody = RequestBody.create(MediaType.get("appplication/json;charset=utf-8"),gson.toJson(req));
      Request request =  new Request.Builder().url("xxx"+action).post(requestBody)
               .build();
      OkHttpClient okHttpClient = new OkHttpClient();
      okHttpClient.newCall(request)
              .enqueue(new Callback() {
                  @Override
                  public void onFailure(Call call, IOException e) {

                  }

                  @Override
                  public void onResponse(Call call, Response response) throws IOException {
                    myCallBack.sendResult(gson.fromJson(response.message(),c),type);
                  }
              });
    }
}
