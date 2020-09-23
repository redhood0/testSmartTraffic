package com.lenovo.smarttraffic;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.lenovo.smarttraffic.greendao.DaoMaster;
import com.lenovo.smarttraffic.greendao.DaoSession;

import java.util.HashSet;
import java.util.Set;

import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author Amoly
 * @date 2019/4/11.
 * description：
 */
public class InitApp extends MultiDexApplication {

    private static Handler mainHandler;
//    private static Context AppContext;
    private static InitApp instance;
    private Set<Activity> allActivities;

    private static DaoSession daoSession;

    public static synchronized InitApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();

        MultiDex.install(this);
//        AppContext = this;
        instance = this;
        mainHandler = new Handler();

        Fragmentation.builder().install();//注册fragmentation


    }

    private void initDB() {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"demo.db",null);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
        //ChongZhiRecordDao recordDao = daoSession.getChongZhiRecordDao();
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"demo.db",null);
//        SQLiteDatabase db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }

    //    public static Context getContext(){
//        return AppContext;
//    }
    public static Handler getHandler(){
        return mainHandler;
    }

    public void addActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<>();
        }
        allActivities.add(act);
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
