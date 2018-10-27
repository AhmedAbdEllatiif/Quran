package com.example.ahmedd.quraan.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmedd.quraan.Adapters.SouraListAdapter;
import com.example.ahmedd.quraan.BaseActivities.BaseFragment;
import com.example.ahmedd.quraan.FragmentsContainer;
import com.example.ahmedd.quraan.Model.SouraModel;
import com.example.ahmedd.quraan.R;
import com.example.ahmedd.quraan.Soura.Soura;
import com.example.ahmedd.quraan.Soura.SouraName;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class QuranFragment extends BaseFragment {

    public static String inner;
    private List<SouraModel> list;
    private SouraListAdapter adapter;
    private View view;

    public QuranFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_quran, container, false);
        FragmentsContainer.my_title.setText(R.string.quran);

        getAllItems();
        setAdapter();
        adapterOnClickListener();
        viewAdMob();

        return view;
    }


    private void setAdapter() {
        adapter = new SouraListAdapter(activity, list);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(adapter);
    }

    private void getAllItems() {
        list = new ArrayList<>();
        for (int i = 0; i < SouraName.souraName().size(); i++) {
            SouraModel souraModel = new SouraModel(SouraName.souraName().get(i) + " (" + (i + 1) + ")");
            list.add(souraModel);
        }
    }

    private void viewAdMob() {
        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(activity, AdMobID);
    }

    private void adapterOnClickListener() {
        adapter.setOnItemClickListener(new SouraListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, SouraModel souraModel) {

                Intent intent = new Intent(activity, Soura.class);
                intent.putExtra("txtFile", (position+1)+".txt" );
                //intent.putExtra(inner = SouraName.souraName().get(position), position);
                inner = SouraName.souraName().get(position);
                intent.putExtra("InnerTitle", inner);
                startActivity(intent);
            }
        });
    }

}
