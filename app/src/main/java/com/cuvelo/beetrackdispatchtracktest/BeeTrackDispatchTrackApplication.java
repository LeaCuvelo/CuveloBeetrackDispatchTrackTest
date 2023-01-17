package com.cuvelo.beetrackdispatchtracktest;
import android.app.Application;

import androidx.multidex.MultiDexApplication;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BeeTrackDispatchTrackApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
    }


}
