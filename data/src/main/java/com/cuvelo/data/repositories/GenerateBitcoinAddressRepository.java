package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;

import io.reactivex.Observable;

//TODO mover a 1 solo repository
public class GenerateBitcoinAddressRepository {

    private final LocalBitcoinWalletAddressDataSource mLocalBitcoinWalletAddressDataSource;
    private final RemoteBitcoinWalletAddressDataSource mRemoteBitcoinWalletAddressDataSource;

    public GenerateBitcoinAddressRepository(LocalBitcoinWalletAddressDataSource mLocalBitcoinWalletAddressDataSource,
                                            RemoteBitcoinWalletAddressDataSource mRemoteBitcoinWalletAddressDataSource) {
        this.mLocalBitcoinWalletAddressDataSource = mLocalBitcoinWalletAddressDataSource;
        this.mRemoteBitcoinWalletAddressDataSource = mRemoteBitcoinWalletAddressDataSource;
    }

    public Observable generateBitcoinWalletAddressFromApi(){
        return mRemoteBitcoinWalletAddressDataSource.generateBitcoinWalletAddress();
    }

    public Observable getBitcoinWalletAddressFromDataBase(){
        return mLocalBitcoinWalletAddressDataSource.getBitcoinWalletAddress();
    }

}