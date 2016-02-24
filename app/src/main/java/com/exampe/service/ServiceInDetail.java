package com.exampe.service;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by Saurabhg on 24-02-2016.
 */
public class ServiceInDetail  extends Service{

    private static final String TAG = ServiceInDetail.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    public ServiceInDetail() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        return null;
    }


    }
}
