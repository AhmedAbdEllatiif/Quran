package com.example.ahmedd.quraan.BaseActivities;

import android.content.Context;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {


   public BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;
    }
}
