package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.AddressDomain;

import io.reactivex.Observable;


public class BitcoinWalletRepository {

    private final LocalBitcoinWalletAddressDataSource mLocalBitcoinWalletAddressDataSource;
    private final RemoteBitcoinWalletAddressDataSource mRemoteBitcoinWalletAddressDataSource;
    private final LocalBitcoinWalletBalanceDataSource mLocalBitcoinWalletBalanceDataSource;
    private final RemoteBitcoinWalletBalanceDataSource mRemoteBitcoinWalletBalanceDataSource;


    public BitcoinWalletRepository(LocalBitcoinWalletAddressDataSource localBitcoinWalletAddressDataSource,
                                   RemoteBitcoinWalletAddressDataSource remoteBitcoinWalletAddressDataSource,
                                   LocalBitcoinWalletBalanceDataSource localBitcoinWalletBalanceDataSource,
                                   RemoteBitcoinWalletBalanceDataSource remoteBitcoinWalletBalanceDataSource){
        this.mLocalBitcoinWalletAddressDataSource = localBitcoinWalletAddressDataSource;
        this.mRemoteBitcoinWalletAddressDataSource = remoteBitcoinWalletAddressDataSource;
        this.mLocalBitcoinWalletBalanceDataSource = localBitcoinWalletBalanceDataSource;
        this.mRemoteBitcoinWalletBalanceDataSource = remoteBitcoinWalletBalanceDataSource;
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

    public Observable<AddressDomain> generateBitcoinWalletAddressFromApi(){
        return mRemoteBitcoinWalletAddressDataSource.generateBitcoinWalletAddress();
    }

    public AddressDomain getBitcoinWalletAddressFromDataBase(){
        return mLocalBitcoinWalletAddressDataSource.getBitcoinWalletAddress();
    }

    //TODO return values to success or error
    public void saveBitcoinWalletAddress(AddressDomain addressDomain){
        mLocalBitcoinWalletAddressDataSource.saveBitcoinWalletAddress(addressDomain);
    }


}
