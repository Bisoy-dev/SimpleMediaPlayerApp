package com.example.mediaplayerapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrackAttribute implements MediaAttributes<Track>{
    private ArrayList<Track> tracks;
    private RecyclerView recyclerView;
    private Context context;
    public TrackAttribute(ArrayList<Track> data, RecyclerView recyclerView, Context context){
        tracks = data;
        this.recyclerView = recyclerView;
        this.context = context;
    }
    public TrackAttribute(ArrayList<Track> data){
        tracks = data;
    }
    @Override
    public void setData(ArrayList<Track> data) {
        tracks = data;
    }

    @Override
    public ArrayList<Track> getData() {
        return tracks;
    }

    @Override
    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Context getContext() {
        return context;
    }
}
