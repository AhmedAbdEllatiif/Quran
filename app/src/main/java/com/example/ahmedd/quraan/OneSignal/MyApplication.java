package com.example.ahmedd.quraan.OneSignal;

import android.app.Application;
import com.onesignal.OneSignal;

public class MyApplication extends Application {
        @Override
        public void onCreate() {
            super.onCreate();

            // OneSignal Initialization
            OneSignal.startInit(this)
                    .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                    .unsubscribeWhenNotificationsAreDisabled(true)
                    .setNotificationOpenedHandler(new MyCustomNotificationOpenedHandler(this))
                    .init();
        }
    }


