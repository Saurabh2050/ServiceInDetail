package com.example.android.serviceindetail;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.exampe.service.ServiceInDetail;

/**
 * Created by Saurabhg on 28-02-2016.
 */
public class SecondActivity extends Activity {
    private static final String TAG = SecondActivity.class.getSimpleName();
    public SecondActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "SecondActivity onCreate");
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "SecondActivity onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i(TAG, "SecondActivity onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SecondActivity onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "SecondActivity onRestart");
    }

    @Override
    public void onStateNotSaved() {
        super.onStateNotSaved();
        Log.i(TAG, "SecondActivity onStateNotSaved");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "SecondActivity onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i(TAG, "SecondActivity onPostResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "SecondActivity onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "SecondActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SecondActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SecondActivity onDestroy");
    }
}
