package com.example.ahmedd.quraan.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ahmedd.quraan.API.ApiManger;
import com.example.ahmedd.quraan.API.Model.RadioItem;
import com.example.ahmedd.quraan.API.Model.RadioResponse;
import com.example.ahmedd.quraan.Adapters.RadioAdapter;
import com.example.ahmedd.quraan.BaseActivities.BaseFragment;
import com.example.ahmedd.quraan.FragmentContainerQuran;
import com.example.ahmedd.quraan.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadioFragment extends BaseFragment {


    private List<RadioItem> radioChannels = new ArrayList<>();
    private RadioAdapter adapter;
    private RecyclerView radio_recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private SnapHelper snapHelper;
    private ImageButton imgBtnPlay;
    private ImageButton imgBtnStop;
    private MediaPlayer mediaPlayer;
    public RadioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_radio, container, false);
        FragmentContainerQuran.my_title.setText(R.string.radio);

        radio_recyclerView = view.findViewById(R.id.radio_recyclerView);
        imgBtnPlay = view.findViewById(R.id.imgBtnPlay);
        imgBtnStop = view.findViewById(R.id.imgBtnStop);
        getRadioChannels();

        imgBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = snapHelper.findSnapView(linearLayoutManager);
                int position = radio_recyclerView.getChildAdapterPosition(v);
                playMediaPlayer(radioChannels.get(position).getURL());

            }
        });


        imgBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMediaPlayer();
            }
        });



        return view;
    }

    private void stopMediaPlayer(){
       if(mediaPlayer !=null && mediaPlayer.isPlaying()) {
           mediaPlayer.stop();
       }
   }

    private void playMediaPlayer(String URL){
        stopMediaPlayer();
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(URL);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void setAdapter(){

        linearLayoutManager =
                new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false);
            adapter = new RadioAdapter(radioChannels);
            radio_recyclerView.setLayoutManager(linearLayoutManager);
            radio_recyclerView.setAdapter(adapter);
            snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(radio_recyclerView);
    }

    private void getRadioChannels(){

        ApiManger.getServices().getRadioChannels()
                .enqueue(new Callback<RadioResponse>() {
                    @Override
                    public void onResponse(Call<RadioResponse> call, Response<RadioResponse> response) {

                       radioChannels = response.body().getRadioItems();
                        setAdapter();
                    }

                    @Override
                    public void onFailure(Call<RadioResponse> call, Throwable t) {

                        showMessage("Error", t.getLocalizedMessage());
                    }
                });

    }


}
