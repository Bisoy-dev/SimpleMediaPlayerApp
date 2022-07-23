package com.example.mediaplayerapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAttribute implements MediaAttributes<Video>{
    private ArrayList<Video> videos;
    private RecyclerView recyclerView;
    private Context context;

    public VideoAttribute(ArrayList<Video> videos){
        this.videos = videos;
    }
    @Override
    public void setData(ArrayList<Video> data) {
        videos = data;
    }

    @Override
    public ArrayList<Video> getData() {
        return videos;
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
