package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;

import io.reactivex.Observable;


//Mover el otro repository aqui y cambiar nombre
public class BitcoinWalletBalanceRepository {

    private final LocalBitcoinWalletBalanceDataSource mLocalBitcoinWalletBalanceDataSource;
    private final RemoteBitcoinWalletBalanceDataSource mRemoteBitcoinWalletBalanceDataSource;

    public BitcoinWalletBalanceRepository(LocalBitcoinWalletBalanceDataSource mLocalBitcoinWalletBalanceDataSource,
                                          RemoteBitcoinWalletBalanceDataSource mRemoteBitcoinWalletBalanceDataSource) {
        this.mLocalBitcoinWalletBalanceDataSource = mLocalBitcoinWalletBalanceDataSource;
        this.mRemoteBitcoinWalletBalanceDataSource = mRemoteBitcoinWalletBalanceDataSource;
    }

    public Observable findBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable findFullBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

    public Observable findBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable findFullBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getFullBalance(address);
    }
}
