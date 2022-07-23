package com.example.mediaplayerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrackFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private MediaAttributes<Track> attribute;
    private ArrayList<Track> reference;
    private EditText editTextSearchSong;
    public TrackFragment(MediaAttributes<Track> attribute) {
        this.attribute = attribute;
        this.reference = attribute.getData();
    }
    public TrackFragment(){
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrackFragment newInstance(String param1, String param2) {
        TrackFragment fragment = new TrackFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_track, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.trackRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        attribute.setContext(getContext());
        attribute.setRecyclerView(recyclerView);
        recyclerView.setAdapter(new TrackAdapter(attribute));

        editTextSearchSong = (EditText) view.findViewById(R.id.etSearchSong);

        editTextSearchSong.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.toString().isEmpty()){
                    attribute.setData(reference);
                    recyclerView.setAdapter(new TrackAdapter(attribute));
                }else {
                    attribute.setData(resultTracks(charSequence));
                    recyclerView.setAdapter(new TrackAdapter(attribute));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    private ArrayList<Track> resultTracks(CharSequence charSequence){
        ArrayList<Track> results = new ArrayList<>();

        for (Track track : reference){
            if (track.getTitle().contains(charSequence)){
                results.add(track);
            }
        }

        return results;
    }
}