package com.example.android.mediaplayer;

import android.media.MediaPlayer;

/**
 * Created by Saurabhg on 13-03-2016.
 */
public class CustomMediaPlayer  extends MediaPlayer{
    private static CustomMediaPlayer customMediaPlayer;

    private CustomMediaPlayer(){

    }
    public static  CustomMediaPlayer getInstance(){
        if(customMediaPlayer == null){
            customMediaPlayer = new CustomMediaPlayer();
        }
        return customMediaPlayer;
    }
}
