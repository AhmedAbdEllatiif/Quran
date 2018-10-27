package com.example.ahmedd.quraan;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.ahmedd.quraan.BaseActivities.BaseActivity;

public class Splash extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(activity,FragmentsContainer.class));
                finish();
            }
        },2500);
    }
}
