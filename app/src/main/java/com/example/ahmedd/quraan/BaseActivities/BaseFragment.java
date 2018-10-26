package com.example.ahmedd.quraan.BaseActivities;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseFragment extends Fragment {

    protected static final String AdMobID = "ca-app-pub-8926610076081506~2692840354";
    protected BaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (BaseActivity) context;


    }

    public MaterialDialog showMessage(String title, String Message){
        return  activity.showMessage(title,Message);
    }

    public MaterialDialog showProgressBar(){
        return activity.showProgressBar("Please Wait", "Loading");
    }

    public void hideProgressBar(){

        activity.hideProgressBar();
    }


}
