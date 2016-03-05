package com.exampe.service;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.android.serviceindetail.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by Saurabhg on 24-02-2016.
 */
public class ServiceInDetail  extends Service{

    private static final String TAG = ServiceInDetail.class.getSimpleName();
    private Thread thread;
    private MediaPlayer medialayer;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "ServiceInDetail onCreate");
    }

    public ServiceInDetail() {
        super();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "ServiceInDetail onStartCommand "+flags );

        //TODO how will you stop the running thread when stoping the service
        //runningThreadFromOnStartCommnd();

        //Start Playing audio
        medialayer = startPlayingAudio();
        return super.onStartCommand(intent, flags, startId);
    }

    private MediaPlayer startPlayingAudio() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.test_audio);
        mediaPlayer.start(); // no need to call prepare(); create() does that for you
        return mediaPlayer;
    }

    private void runningThreadFromOnStartCommnd() {

        thread = new DummyThread();
        thread.start();

//        new Thread(new Runnable() {
//            int i = 1;
//            public void run() {
//               while (i>0){
//                   Log.i(TAG, "repetivit HI " + i++);
//               }
//            }
//        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "ServiceInDetail onDestroy");
        //thread.interrupt();
        stopMediaPlayer();
    }

    public void stopMediaPlayer(){
        medialayer.release();
        medialayer = null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "ServiceInDetail onConfigurationChanged");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(TAG, "ServiceInDetail onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i(TAG, "ServiceInDetail onTrimMemory");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "ServiceInDetail onUnbind");
        return super.onUnbind(intent);

    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i(TAG, "ServiceInDetail onRebind");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.i(TAG, "ServiceInDetail onTaskRemoved");
    }

    @Override
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
        Log.i(TAG, "ServiceInDetail dump");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"ServiceInDetail onBind");
        return null;
    }
class DummyThread extends Thread{
    @Override
    public void run() {
        super.run();
        int i =1;
        while (i>0){
            Log.i(TAG, "repetivit HI " + i++);
        }
    }
}
}
