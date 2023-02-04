package com.cuvelo.beetrackdispatchtracktest.utils;






import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;

public class ConnectivityUtils {

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return cm.getActiveNetwork() != null && cm.getNetworkCapabilities(cm.getActiveNetwork()) != null;
        } else {
            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
        }
    }

}
