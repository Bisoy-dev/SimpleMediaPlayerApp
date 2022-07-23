package com.example.mediaplayerapp;

public class Track {
    private String artist;
    private String uri;
    private String title;

    public Track(String artist, String uri, String title){
        this.artist = artist;
        this.uri = uri;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
