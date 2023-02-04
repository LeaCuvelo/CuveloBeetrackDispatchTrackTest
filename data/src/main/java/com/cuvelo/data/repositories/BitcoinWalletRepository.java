package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;


public class BitcoinWalletRepository {

    private final RemoteBitcoinWalletAddressDataSource mRemoteBitcoinWalletAddressDataSource;
    private final LocalBitcoinWalletBalanceDataSource mLocalBitcoinWalletBalanceDataSource;
    private final RemoteBitcoinWalletBalanceDataSource mRemoteBitcoinWalletBalanceDataSource;


    public BitcoinWalletRepository(RemoteBitcoinWalletAddressDataSource remoteBitcoinWalletAddressDataSource,
                                   LocalBitcoinWalletBalanceDataSource localBitcoinWalletBalanceDataSource,
                                   RemoteBitcoinWalletBalanceDataSource remoteBitcoinWalletBalanceDataSource){
        this.mRemoteBitcoinWalletAddressDataSource = remoteBitcoinWalletAddressDataSource;
        this.mLocalBitcoinWalletBalanceDataSource = localBitcoinWalletBalanceDataSource;
        this.mRemoteBitcoinWalletBalanceDataSource = remoteBitcoinWalletBalanceDataSource;
    }


    public Observable<BalanceDomain> getBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> findFullBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

    public Observable<AddressDomain> generateBitcoinWalletAddressFromApi(){
        return mRemoteBitcoinWalletAddressDataSource.generateBitcoinWalletAddress();
    }

    public void saveBalance(BalanceDomain balanceDomain){
        mLocalBitcoinWalletBalanceDataSource.saveBalance(balanceDomain);
    }
    
    public Observable<BalanceDomain> getBalance(String address){
        //TODO offline mode, WIP on the following way of catch data from DB or API
        //Observable<BalanceDomain> databaseObservable = getBalanceByAddressFromDataBase(address);
        //Observable<BalanceDomain> networkObservable = getBalanceByAddressFromApi(address);
        //return Observable.concat(databaseObservable, networkObservable);


        return getBalanceByAddressFromApi(address);
    }

    public Observable<BalanceDomain> getBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> getFullBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

}