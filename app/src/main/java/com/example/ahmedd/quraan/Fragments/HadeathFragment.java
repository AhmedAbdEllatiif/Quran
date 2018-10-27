package com.example.ahmedd.quraan.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmedd.quraan.Adapters.HadethAdapter;
import com.example.ahmedd.quraan.BaseActivities.BaseFragment;
import com.example.ahmedd.quraan.FragmentsContainer;
import com.example.ahmedd.quraan.Model.HadethModel;
import com.example.ahmedd.quraan.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HadeathFragment extends BaseFragment {

    private View view;

    public HadeathFragment() {}


    ArrayList<HadethModel> hadethModels;
    HadethAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hadeath, container, false);
        FragmentsContainer.my_title.setText(R.string.hadeath);

        setAdapter();
        adapterOnClickListener();


    return view;
    }

    private void adapterOnClickListener(){

        adapter.setOnCardClickListener(new HadethAdapter.onItemClickListener() {
            @Override
            public void onClick(int position, HadethModel itemView) {
                HadethDilaogFramgent dilaogFramgent = new HadethDilaogFramgent();
                dilaogFramgent.setTitle(itemView.getTitle());
                dilaogFramgent.setContent(itemView.getContent());

                dilaogFramgent.show(getChildFragmentManager(),"Dialog");
            }
        });
    }

    private void setAdapter(){
        hadethModels = readHadethFile();
        recyclerView = view.findViewById(R.id.hadeth_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new HadethAdapter(hadethModels,activity);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<HadethModel> readHadethFile(){
        ArrayList<HadethModel> hadethModels = new ArrayList<>();


        InputStream inputStream = null;
        InputStreamReader streamReader = null;
        BufferedReader bufferedReader = null;

        try {
            inputStream = activity.getResources().getAssets().open("ahadith_arabic.txt", Context.MODE_WORLD_READABLE);
            streamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(streamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                HadethModel itemView = new HadethModel();
                itemView.setTitle(line);
               while((line = bufferedReader.readLine()) != null){
                   if (line.equals("#")){
                       break;
                   }
                   itemView.setContent(itemView.getContent() + "\n" + line);
               }
                hadethModels.add(itemView);
            }


        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (streamReader != null)
                    streamReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
            return hadethModels;
    }

}
