package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.data.repositories.BitcoinWalletRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataModule {

    @Provides
    public BitcoinWalletRepository provideBitcoinWalletRepository(
            LocalBitcoinWalletAddressDataSource localBitcoinWalletAddressDataSource,
            RemoteBitcoinWalletAddressDataSource remoteBitcoinWalletAddressDataSource,
            LocalBitcoinWalletBalanceDataSource localBitcoinWalletBalanceDataSource,
            RemoteBitcoinWalletBalanceDataSource remoteBitcoinWalletBalanceDataSource){
        return new BitcoinWalletRepository(
                localBitcoinWalletAddressDataSource,
                remoteBitcoinWalletAddressDataSource,
                localBitcoinWalletBalanceDataSource,
                remoteBitcoinWalletBalanceDataSource);
    }
}