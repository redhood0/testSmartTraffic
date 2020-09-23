package com.lenovo.smarttraffic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * @author Amoly
 * @date 2019/4/11.
 * description：
 */
public class SplashActivity extends AppCompatActivity {
    String FRIST_START = "first";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

//        ViewGroup decor = (ViewGroup) getWindow().getDecorView();
//        SharedPreferences sp = getSharedPreferences("firstUser", MODE_PRIVATE);
//
//        String first = sp.getString("firstUser", "");

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

//        if (first.equals("yes")) {
//            Log.e("sss", "onCreate: "+">>>>>>>>>>>>>>>yes" );
////            decor.setBackgroundResource(R.drawable.bg_splash);
//            getWindow().setBackgroundDrawableResource(R.drawable.bg_splash);
//            SharedPreferences.Editor di = sp.edit();
//            di.putString("firstUser","yes");
//            di.apply();
//
//            Handler handler = new Handler();
//            handler.postDelayed(() ->{
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            },3000);

//        } else {
//            getWindow().setBackgroundDrawableResource(R.color.alpha_0);
////            decor.setBackgroundResource(R.color.alpha_0);
//            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }

//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SharedPreferences sd = getSharedPreferences("first", 0);
        String sd1 = sd.getString("first", "");

        if (!sd1.equals("first")) {
            Log.e("onCreate:>> ", "onCreate:>> "+sd1 );
//            getWindow().setBackgroundDrawableResource(R.color.alpha_0);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Log.e("onCreate2:>> ", "onCreate2:>> "+sd1 );

            SharedPreferences.Editor editor=sd.edit();
            editor.putString("first", "first");
            editor.apply();

            getWindow().setBackgroundDrawableResource(R.drawable.bg_splash);

            Handler handler = new Handler();
            handler.postDelayed(() -> {
//                        getWindow().setBackgroundDrawableResource(R.color.alpha_0);
                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    },
                    3000);
        }

        super.onCreate(savedInstanceState);

    }

}
