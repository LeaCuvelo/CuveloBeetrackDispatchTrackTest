package com.cuvelo.data.datasources;

import com.cuvelo.domain.AddressDomain;

import io.reactivex.Observable;


public interface LocalBitcoinWalletAddressDataSource {
    Observable<AddressDomain> getBitcoinWalletAddress();
    void saveBitcoinWalletAddress(AddressDomain addressDomain);
}

