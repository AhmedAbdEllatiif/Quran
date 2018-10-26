package com.example.ahmedd.quraan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ahmedd.quraan.BaseActivities.BaseActivity;
import com.example.ahmedd.quraan.Fragments.HadeathFragment;
import com.example.ahmedd.quraan.Fragments.QuranFragment;
import com.example.ahmedd.quraan.Fragments.RadioFragment;


public class MainContainer extends BaseActivity {


    public static TextView my_title;
    private Toolbar toolbar;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {



        Fragment fragment;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.quran:
                 fragment = new QuranFragment();
                  break;
                case R.id.ahadeath:
                    fragment = new HadeathFragment();
                  break;
                case R.id.radio:
                    fragment = new RadioFragment();
                    break;
            }

            Log.e("Fragment", "Replacing Fragment");
            getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit();
            return true;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_);



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.quran);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar()
        .setDisplayShowTitleEnabled(false);

        my_title = (TextView) findViewById(R.id.my_title) ;
        my_title.setText(R.string.quran);


    }

}
