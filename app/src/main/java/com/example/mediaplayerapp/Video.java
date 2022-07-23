package com.example.mediaplayerapp;

public class Video {
    private String title;
    private String uri;

    public Video(String title, String uri){
        this.title = title;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getTitle() {
        return title;
    }
}
