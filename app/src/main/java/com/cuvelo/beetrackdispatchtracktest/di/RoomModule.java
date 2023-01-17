package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.beetrackdispatchtracktest.data.LocalBitcoinWalletAddressDataSourceImpl;
import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    @Provides
    @Singleton
    public LocalBitcoinWalletAddressDataSource provideLocalBitcoinWalletAddressDataSource(){
        return new LocalBitcoinWalletAddressDataSourceImpl();
    }

}
