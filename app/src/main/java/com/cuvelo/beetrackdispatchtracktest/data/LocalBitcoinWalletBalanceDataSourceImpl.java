package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;

import io.reactivex.Observable;

public class LocalBitcoinWalletBalanceDataSourceImpl implements LocalBitcoinWalletBalanceDataSource {

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
