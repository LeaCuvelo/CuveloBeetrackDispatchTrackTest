package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;

import io.reactivex.Observable;

public class LocalBitcoinWalletAddressDataSourceImpl implements LocalBitcoinWalletAddressDataSource {

    private String TAG = "LocalBitcoinWalletAddressDataSourceImpl";


    @Override
    public Observable getBitcoinWalletAddress() {
        //TODO
        return null;
    }
}
