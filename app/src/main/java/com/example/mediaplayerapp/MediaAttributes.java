package com.example.mediaplayerapp;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public interface MediaAttributes<T> {
    void setData(ArrayList<T> data);
    ArrayList<T> getData();
    void setRecyclerView(RecyclerView recyclerView);
    RecyclerView getRecyclerView();
    void setContext(Context context);
    Context getContext();
}
