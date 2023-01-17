package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressModelDataMapper;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.domain.AddressDomain;

import io.reactivex.Observable;

public class RemoteBitcoinWalletAddressDataSourceImpl implements RemoteBitcoinWalletAddressDataSource {

    private String TAG = "RemoteBitcoinWalletAddressDataSourceImpl";
    private final BitcoinWalletRemoteServer bitcoinWalletRemoteServer;
    private final AddressModelDataMapper addressModelDataMapper;


    public RemoteBitcoinWalletAddressDataSourceImpl(BitcoinWalletRemoteServer mBitcoinWalletRemoteServer,
                                                    AddressModelDataMapper mAddressModelDataMapper) {
        this.bitcoinWalletRemoteServer = mBitcoinWalletRemoteServer;
        this.addressModelDataMapper = mAddressModelDataMapper;
    }

    @Override
    public Observable<AddressDomain> generateBitcoinWalletAddress() {
        return bitcoinWalletRemoteServer.generateBitcoinAddress().map(addressModelDataMapper::transform);
    }


}
