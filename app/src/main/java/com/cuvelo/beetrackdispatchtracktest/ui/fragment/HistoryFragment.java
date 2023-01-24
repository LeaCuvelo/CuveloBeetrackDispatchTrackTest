package com.cuvelo.beetrackdispatchtracktest.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuvelo.beetrackdispatchtracktest.R;


public class HistoryFragment extends Fragment {

    private final String btcAddress;

    public HistoryFragment(String btcAddress) {
        this.btcAddress = btcAddress;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }
}