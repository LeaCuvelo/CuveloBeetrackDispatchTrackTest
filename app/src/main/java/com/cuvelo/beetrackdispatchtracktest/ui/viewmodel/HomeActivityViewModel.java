package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cuvelo.domain.BalanceDomain;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeActivityViewModel extends ViewModel {

    private static final String TAG = "HomeActivityViewModel";

    @Inject
    public HomeActivityViewModel() {
        Log.d(TAG,"HomeActivityViewModel");
    }
}
