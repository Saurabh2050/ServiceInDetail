package com.example.android.serviceindetail;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.exampe.service.ServiceInDetail;
import com.example.android.webviewindetail.MyWebView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String TAG = MainActivityFragment.class.getSimpleName();
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button statBtn = (Button) view.findViewById(R.id.startbutton);
        statBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getActivity(), ServiceInDetail.class);
                getActivity().startService(serviceIntent);
//                new Thread(new Runnable() {
//                    int i = 1;
//                    public void run() {
//                        while (i>0){
//                            Log.i(TAG, "repetivit HI "+i++);
//                        }
//                    }
//                }).start();

            }
        });
        Button stopBtn = (Button) view.findViewById(R.id.stopbutton);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To demonstrate Activity life cycle
//                Intent launchSecond = new Intent(getActivity(), SecondActivity.class);
//                getActivity().startActivity(launchSecond);
                Intent serviceIntent = new Intent(getActivity(), ServiceInDetail.class);
                getActivity().stopService(serviceIntent);

            }
        });
        Button launchWebview = (Button) view.findViewById(R.id.launchwebview);
        launchWebview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchWebviewActivity();

            }
        });
        return view;
    }

    private void launchWebviewActivity() {
        Intent webViewIntent = new Intent(getActivity(), MyWebView.class);
        getActivity().startActivity(webViewIntent);
    }
}
