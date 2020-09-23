package com.lenovo.smarttraffic.ui.zujian;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyNetWorkService extends Service {

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e(">>>>", "onReceive:>>>>>>>>>>>> "+action );
          ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfonetworkInfo =  manager.getActiveNetworkInfo();
            if(networkInfonetworkInfo == null){
                Log.e("sss", "onReceive: >>>null" );
            }else {
                Log.e("sss", "onReceive: >>>"+ networkInfonetworkInfo.isAvailable()+">>>"+ networkInfonetworkInfo.isConnected());

            }

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    //绑定过滤器，动态监听xxxAction
    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver,mFilter);

//        IntentFilter intentFilter  = new IntentFilter();
//        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(receiver,intentFilter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
