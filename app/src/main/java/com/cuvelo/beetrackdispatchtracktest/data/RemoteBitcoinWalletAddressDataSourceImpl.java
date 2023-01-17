package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;

import io.reactivex.Observable;

public class RemoteBitcoinWalletAddressDataSourceImpl implements RemoteBitcoinWalletAddressDataSource {

    private String TAG = "RemoteBitcoinWalletAddressDataSourceImpl";
    private final BitcoinWalletRemoteServer bitcoinWalletRemoteServer;


    public RemoteBitcoinWalletAddressDataSourceImpl(BitcoinWalletRemoteServer mBitcoinWalletRemoteServer) {
        this.bitcoinWalletRemoteServer = mBitcoinWalletRemoteServer;
    }

    @Override
    public Observable generateBitcoinWalletAddress() {
        //TODO map from domain to model
        Observable algo = bitcoinWalletRemoteServer.generateBitcoinAddress();





        return algo;
    }


}
