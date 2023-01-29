package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;


//TODO refactor this class, and delete unused methods
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



    public Observable<BalanceDomain> findBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> findFullBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

    public Observable<AddressDomain> generateBitcoinWalletAddressFromApi(){
        return mRemoteBitcoinWalletAddressDataSource.generateBitcoinWalletAddress();
    }

    public Observable<AddressDomain> getBitcoinWalletAddressFromDataBase(){
        return mLocalBitcoinWalletAddressDataSource.getBitcoinWalletAddress();
    }

    //TODO return values to success or error
    public void saveBitcoinWalletAddress(AddressDomain addressDomain){
        mLocalBitcoinWalletAddressDataSource.saveBitcoinWalletAddress(addressDomain);
    }

    public void saveBalance(BalanceDomain balanceDomain){
        mLocalBitcoinWalletBalanceDataSource.saveBalance(balanceDomain);
    }



    public Observable<BalanceDomain>  getBalance(String address){
        //TODO intercept the values from API and check if is empty
        //TODO retrieve data from Database check if is ok

       /* Observable<BalanceDomain> balanceFromApi = getBalanceByAddressFromApi(address);

        if(balanceFromApi ){ //TODO check if data is empty

            return  findBalanceByAddressFromDataBase(address);
        }else{
            return balanceFromApi;
        }*/

        //TODO right now only return from API
        return getBalanceByAddressFromApi(address);

    }

    public Observable<BalanceDomain> getBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> getFullBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getFullBalance(address);
    }


}
