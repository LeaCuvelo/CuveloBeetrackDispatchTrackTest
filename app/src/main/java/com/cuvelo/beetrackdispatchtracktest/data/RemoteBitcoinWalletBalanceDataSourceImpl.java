package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;

import io.reactivex.Observable;

public class RemoteBitcoinWalletBalanceDataSourceImpl implements RemoteBitcoinWalletBalanceDataSource {

    //TODO implement methods

    @Override
    public Observable getBalance(String address) {
        return null;
    }

    @Override
    public Observable getFullBalance(String address) {
        return null;
    }
}