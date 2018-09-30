package com.example.ahmedd.quraan.Fragments;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;


public class QuranFragment extends BaseFragment {

    public static String inner;
    SouraName souraName;


    public QuranFragment() {
        // Required empty public constructor
    }


        View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_quran, container, false);
        MainContainer.my_title.setText(R.string.quran);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        souraName = new SouraName();


        List<ItemView> list = new ArrayList<>();
        SouraListAdapter adapter = new SouraListAdapter(activity, list);


        for (int i = 0; i< SouraName.souraName().size(); i++ ){

            ItemView itemView = new ItemView(SouraName.souraName().get(i) + " (" + (i+1) + ")");

            list.add(itemView);
        }


        adapter.setOnItemClickListener(new SouraListAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, ItemView itemView) {

                Intent intent = new Intent(activity,Soura.class);
                Soura.txtFile = (position+1) + ".txt";
                intent.putExtra(Soura.txtFile,  position);
                intent.putExtra(inner = SouraName.souraName().get(position), position);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
    return view;
    }

}
