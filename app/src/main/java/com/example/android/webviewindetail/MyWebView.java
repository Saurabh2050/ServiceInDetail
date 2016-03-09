package com.example.android.webviewindetail;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.android.serviceindetail.R;

/**
 * Created by Saurabhg on 06-03-2016.
 */
public class MyWebView extends AppCompatActivity implements View.OnClickListener{
    private  JavaScriptHanlder javascriptInterface;
    private WebView mywebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initView();
         javascriptInterface = new JavaScriptHanlder(this,mywebview);


    }

    private void initView() {
         mywebview = (WebView) findViewById(R.id.mywebview);
        Button callJSBtn = (Button) findViewById(R.id.call_js_funcion);
        Button callAndroidBtn= (Button) findViewById(R.id.call_android_method);
        callJSBtn.setOnClickListener(this);
        setWebviewProperties(mywebview);
        //mywebview.loadUrl("http://android-developers.blogspot.in/2015/12/get-ready-for-javascript-promises-with.html");
        mywebview.loadUrl("file:///android_asset/first.html");
    }

    private void setWebviewProperties(WebView mywebview) {
        // Used to handle navigation by itselft rather than a default one systme provides
        mywebview.setWebViewClient(new WebViewClient());

        WebSettings websettings = mywebview.getSettings();
        // used for calling andoid methods from javascript and javascript functions from android
        websettings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }


       //this has been added to add show aler dialog on web view, find more reasons and difference between webviewclient and webchromeclient
        mywebview.setWebChromeClient(new WebChromeClient());

        // Set JavaScript Interface
       // mywebview.addJavascriptInterface(javascriptInterface,"Android");   // this didn't work
        mywebview.addJavascriptInterface(new JavaScriptHanlder(this,mywebview),"Android");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call_js_funcion:
                javascriptInterface.javaFnCall("Hey, Im calling from Android-Java");
                break;

            default:
                break;
        }
    }
}
