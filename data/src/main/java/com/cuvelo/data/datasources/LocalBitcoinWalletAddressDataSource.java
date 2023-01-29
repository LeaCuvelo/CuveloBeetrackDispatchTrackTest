package com.cuvelo.data.datasources;

import com.cuvelo.domain.AddressDomain;
import com.cuvelo.domain.BalanceDomain;

import io.reactivex.Observable;


public interface LocalBitcoinWalletAddressDataSource {
    Observable<AddressDomain> getBitcoinWalletAddress();
    void saveBitcoinWalletAddress(AddressDomain addressDomain);

}

