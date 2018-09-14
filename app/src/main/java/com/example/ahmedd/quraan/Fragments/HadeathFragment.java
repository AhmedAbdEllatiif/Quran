package com.example.ahmedd.quraan.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmedd.quraan.BaseActivities.BaseFragment;
import com.example.ahmedd.quraan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HadeathFragment extends BaseFragment {


    public HadeathFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeath, container, false);
    }

}
