package com.cuvelo.data.datasources;

import io.reactivex.Observable;

public interface LocalBitcoinWalletAddressDataSource {

    public Observable getBitcoinWalletAddress();

}
