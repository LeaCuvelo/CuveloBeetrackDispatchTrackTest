package com.cuvelo.data.datasources;

import io.reactivex.Observable;

public interface RemoteBitcoinWalletBalanceDataSource {
    public Observable getBalance(String address);
    public Observable getFullBalance(String address);
}
