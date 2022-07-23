package com.example.mediaplayerapp;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    MediaAttributes<Video> attribute;
    FragmentActivity fragmentActivity;
    public VideoAdapter(MediaAttributes<Video> attribute, FragmentActivity fragmentActivity){
        this.attribute = attribute;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_row, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = attribute.getRecyclerView().getChildLayoutPosition(view);
                fragmentActivity.getSupportFragmentManager()
                        .beginTransaction().replace(R.id.frameLayout, new VideoViewFragment(attribute.getData().get(position).getUri()))
                        .commit();
            }
        });
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
//        MediaController mediaController = new MediaController(attribute.getContext());
        holder.tvTitle.setText(attribute.getData().get(position).getTitle());
//        holder.videoView.setVideoURI(Uri.parse(attribute.getData().get(position).getUri()));
//        mediaController.setAnchorView(holder.videoView);
//        holder.videoView.setMediaController(mediaController);
//        holder.videoView.start();
    }

    @Override
    public int getItemCount() {
        return attribute.getData().size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder{

//        VideoView videoView;
        TextView tvTitle;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
//            videoView = itemView.findViewById(R.id.videoView);
            tvTitle = itemView.findViewById(R.id.tvVideoTitle);
        }
    }
}
