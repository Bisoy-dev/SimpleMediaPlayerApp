package com.example.mediaplayerapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.util.ArrayList;

public class TrackPlayer {
    private static MediaPlayer player;
    private static String currentTrackPlayed = "";
    private static String previousTrackPlayed = "init";

    public static void trackPlayToggle(Context context, String trackUri){
        if (player == null){
            player = new MediaPlayer();
        }
        currentTrackPlayed = trackUri;
        if (currentTrackPlayed == previousTrackPlayed){
            if (player.isPlaying()){
                player.stop();
            }else {
                player = MediaPlayer.create(context, Uri.parse(trackUri));
                player.start();
            }
        }else {
            if (player.isPlaying()){
                player.stop();
            }
            player = MediaPlayer.create(context, Uri.parse(trackUri));
            player.start();
        }
        previousTrackPlayed = currentTrackPlayed;
    }
}
