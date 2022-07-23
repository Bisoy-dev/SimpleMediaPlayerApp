package com.example.mediaplayerapp;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideoViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String videoUri;
    VideoView videoView;
    ImageView imageViewBack;
    public VideoViewFragment() {
        // Required empty public constructor
    }
    public VideoViewFragment(String videoUri){
        this.videoUri = videoUri;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoViewFragment newInstance(String param1, String param2) {
        VideoViewFragment fragment = new VideoViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MediaController mediaController = new MediaController(getContext());
        View view = inflater.inflate(R.layout.fragment_video_view, container, false);
        videoView = (VideoView) view.findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(videoUri));
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setLooping(true);
//                videoView.start();
//            }
//        });

//        imageViewBack = (ImageView) view.findViewById(R.id.imageViewBack);
//        imageViewBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
        // Inflate the layout for this fragment
        return view;
    }
}