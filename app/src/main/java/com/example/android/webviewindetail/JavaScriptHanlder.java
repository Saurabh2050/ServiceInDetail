package com.example.android.webviewindetail;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by Saurabhg on 06-03-2016.
 */
public class JavaScriptHanlder {

    private  WebView webView;
    private AppCompatActivity activity;

    /** Instantiate the interface and set the context */
    JavaScriptHanlder(AppCompatActivity c,WebView webView) {
        activity = c;
        this.webView = webView;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show();
    }

    public void javaFnCall(String jsString) {

        final String webUrl = "Javascript:diplayJavaMsg('"+jsString+"')";
        // Add this to avoid android.view.windowmanager$badtokenexception unable to add window
        if(!activity.isFinishing())
            // loadurl on UI main thread
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    webView.loadUrl(webUrl);
                }
            });
    }
}
