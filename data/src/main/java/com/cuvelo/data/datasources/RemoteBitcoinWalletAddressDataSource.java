package com.cuvelo.data.datasources;

import com.cuvelo.domain.AddressDomain;

import io.reactivex.Observable;

public interface RemoteBitcoinWalletAddressDataSource {
    Observable<AddressDomain> generateBitcoinWalletAddress();
}
