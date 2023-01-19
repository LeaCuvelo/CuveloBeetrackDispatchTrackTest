package com.cuvelo.data.datasources;

import com.cuvelo.domain.AddressDomain;


public interface LocalBitcoinWalletAddressDataSource {
    AddressDomain getBitcoinWalletAddress();
    void saveBitcoinWalletAddress(AddressDomain addressDomain);
}

