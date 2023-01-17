package com.cuvelo.data.datasources;

import io.reactivex.Observable;

public interface RemoteBitcoinWalletAddressDataSource {
    public Observable generateBitcoinWalletAddress();
}
