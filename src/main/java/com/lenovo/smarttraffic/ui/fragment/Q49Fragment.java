package com.lenovo.smarttraffic.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.lenovo.smarttraffic.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q49Fragment extends SupportFragment {
    @BindView(R.id.wv)
    WebView wv;
    Unbinder unbinder;
    Thread thread ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.q49_fragment, container, false);

        unbinder = ButterKnife.bind(this, v);

        wv.loadUrl("file:///android_asset/test.html");
//        wv.loadUrl("file:///android_asset/test.html");
//        wv.loadUrl("file:///android_asset/test.html");
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        testWeb(getContext());
                    }catch (NullPointerException e){

                    }

                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
//        wv.post();

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    boolean flag = false;
    AlertDialog.Builder builder;
    AlertDialog dialog;
    private void testWeb(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info =  cm.getActiveNetworkInfo();

        if(info == null){
            Log.e("ss", "testWeb: no" );
            builder = new AlertDialog.Builder(context).setIcon(R.mipmap.icon101)
                    .setTitle("提示")
                    .setMessage("网络已经断开")
                    .setCancelable(false)
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            flag = false;
            if(dialog != null && dialog.isShowing() && !flag){
                return;
            }
            wv.post(new Runnable() {
                @Override
                public void run() {
                    dialog =  builder.show();
                }
            });


            return;
        }
        if(info.isAvailable()){

            flag = true;
            builder = new AlertDialog.Builder(context).setIcon(R.mipmap.icon101)
                    .setTitle("提示")
                    .setMessage("网络已连接")
                    .setCancelable(false)
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            if(dialog != null && dialog.isShowing()&&flag){
                return;
            }

            wv.post(new Runnable() {
                @Override
                public void run() {
                    dialog =  builder.show();
                }
            });

            Log.e("ss", "testWeb: yes" );
        }else {
            Log.e("ss", "testWeb: no" );
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}
