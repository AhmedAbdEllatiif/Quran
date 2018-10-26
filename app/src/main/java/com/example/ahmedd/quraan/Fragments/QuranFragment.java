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
import com.example.ahmedd.quraan.MainContainer;
import com.example.ahmedd.quraan.Model.ItemView;
import com.example.ahmedd.quraan.R;
import com.example.ahmedd.quraan.Soura;
import com.example.ahmedd.quraan.SouraName;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class QuranFragment extends BaseFragment {

    public static String inner;
    private List<ItemView> list;
    private SouraListAdapter adapter;
    private View view;

    public QuranFragment() {}



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MobileAds.initialize(activity, AdMobID);

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quran, container, false);
        MainContainer.my_title.setText(R.string.quran);

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
            ItemView itemView = new ItemView(SouraName.souraName().get(i) + " (" + (i + 1) + ")");
            list.add(itemView);
        }
    }

    private void viewAdMob() {
        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void adapterOnClickListener() {
        adapter.setOnItemClickListener(new SouraListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {

                Intent intent = new Intent(activity, Soura.class);
                Soura.txtFile = (position + 1) + ".txt";
                intent.putExtra(Soura.txtFile, position);
                intent.putExtra(inner = SouraName.souraName().get(position), position);
                startActivity(intent);
            }
        });
    }

}
