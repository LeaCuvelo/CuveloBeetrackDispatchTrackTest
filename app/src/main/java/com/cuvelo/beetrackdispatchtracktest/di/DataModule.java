package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.repositories.GenerateBitcoinAddressRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataModule {

    @Provides
    public GenerateBitcoinAddressRepository provideGenerateBitcoinAddressRepository(
            LocalBitcoinWalletAddressDataSource localBitcoinWalletAddressDataSource,
            RemoteBitcoinWalletAddressDataSource remoteBitcoinWalletAddressDataSource){
        return new GenerateBitcoinAddressRepository(localBitcoinWalletAddressDataSource,
                                                    remoteBitcoinWalletAddressDataSource);
    }


}
