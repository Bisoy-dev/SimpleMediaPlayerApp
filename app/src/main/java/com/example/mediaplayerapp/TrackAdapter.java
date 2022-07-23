package com.example.mediaplayerapp;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackViewHolder> {
    private MediaAttributes<Track> attribute;
    public TrackAdapter(MediaAttributes<Track> attribute){
        this.attribute = attribute;
    }

    @NonNull
    @Override
    public TrackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_row, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = attribute.getRecyclerView().getChildLayoutPosition(view);
                TrackPlayer.trackPlayToggle(attribute.getContext(),attribute.getData().get(position).getUri());
            }
        });
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackViewHolder holder, int position) {
        holder.textViewArtist.setText(attribute.getData().get(position).getArtist());
        holder.textViewTrackTitle.setText(attribute.getData().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return attribute.getData().size();
    }

    class TrackViewHolder extends RecyclerView.ViewHolder{

        ImageView trackImageView;
        TextView textViewArtist, textViewTrackTitle;
        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            trackImageView = itemView.findViewById(R.id.trackImgView);
            textViewArtist = itemView.findViewById(R.id.tvArtist);
            textViewTrackTitle = itemView.findViewById(R.id.tvTrackTitle);
        }
    }
}
