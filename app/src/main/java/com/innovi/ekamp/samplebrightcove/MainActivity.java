package com.innovi.ekamp.samplebrightcove;

import android.os.Bundle;
import android.util.Log;

import com.brightcove.player.media.Catalog;
import com.brightcove.player.media.VideoListener;
import com.brightcove.player.model.Video;
import com.brightcove.player.view.BrightcovePlayer;
import com.brightcove.player.view.BrightcoveVideoView;


public class MainActivity extends BrightcovePlayer {

    //TODO please enter in your video token authentication id
    public final static String VIDEO_TOKEN = "";
    private Catalog catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        brightcoveVideoView = (BrightcoveVideoView) findViewById(R.id.video_view);
        catalog = new Catalog(VIDEO_TOKEN);
        //TODO please enter in the video id
        playMovie("VideoID");
        super.onCreate(savedInstanceState);
    }

    private void playMovie(String id){
        if(catalog != null){
            catalog.findVideoByReferenceID(id, new VideoListener() {
                @Override
                public void onVideo(Video video) {
                    brightcoveVideoView.add(video);
                    brightcoveVideoView.start();
                }

                @Override
                public void onError(String s) {
                    Log.e("ERROR", "Could not play movie " + s);
                }
            });
        }
    }
}