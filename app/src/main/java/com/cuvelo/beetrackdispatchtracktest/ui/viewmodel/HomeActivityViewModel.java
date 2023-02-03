package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeActivityViewModel extends ViewModel {

    private static final String TAG = "HomeActivityViewModel";

    public MutableLiveData<String> addressMutableLiveData = new MutableLiveData<>();

    @Inject
    public SharedPreferences btcAddressSharedPreference;
    private static final String BTC_ADDRESS_KEY = "BTC_ADDRESS_KEY";

    @Inject
    public HomeActivityViewModel(){
    }

    public void setAddress(){
        addressMutableLiveData.setValue(readBtcAddressFromSharedPreferences());
    }

    private String readBtcAddressFromSharedPreferences(){
        String btcAddress = btcAddressSharedPreference.getString(BTC_ADDRESS_KEY, "");
        Log.d(TAG, "BTC ADDRESS: " + btcAddress);
        return btcAddress;
    }

}
