package com.example.mediaplayerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    HomeFragment homeFragment;
    TrackFragment trackFragment;
    VideoFragment videoFragment;

    ArrayList<Track> tracks;
    ArrayList<Video> videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        showPermission();
        instanciateFragments();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, homeFragment)
                .commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout, homeFragment)
                                .commit();
                        return true;
                    case R.id.tracks:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout, trackFragment)
                                .commit();
                        return true;
                    case R.id.video:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frameLayout, videoFragment)
                                .commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    void showPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, 111);
        }else{
            // Load Data from external storage.
            loadData();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            // Load data from external storage.
            loadData();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},111);
        }
    }

    void instanciateFragments(){
        homeFragment = new HomeFragment();
        trackFragment = new TrackFragment(new TrackAttribute(tracks));
        videoFragment = new VideoFragment(new VideoAttribute(videos));
    }
    private ArrayList<Video> getVideos(){
        ArrayList<Video> videos = new ArrayList<>();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = { MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.TITLE};
        Cursor cursor = getApplicationContext()
                .getContentResolver()
                .query(uri, projection, null, null, null, null);

        if (cursor != null){
            while (cursor.moveToNext()){
                String title = cursor.getString(1);
                String videoUri = cursor.getString(0);

                videos.add(new Video(title, videoUri));
            }
        }
        return videos;
    }
    void loadVideos(){
        this.videos = getVideos();
    }
    void loadTracks(){
        this.tracks = getTracks();
    }
    private ArrayList<Track> getTracks(){
        ArrayList<Track> tracks = new ArrayList<>();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = { MediaStore.Audio.Media.DATA, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST };
        Cursor cursor = getApplicationContext()
                .getContentResolver()
                .query(uri, projection, null, null, null, null);

        if (cursor != null){
            while (cursor.moveToNext()){
                String trackUri = cursor.getString(0);
                String title = cursor.getString(1);
                String artist = cursor.getString(2);

                tracks.add(new Track(artist, trackUri, title));
            }
        }

        return tracks;
    }
    void loadData(){
        loadTracks();
        loadVideos();
    }
}