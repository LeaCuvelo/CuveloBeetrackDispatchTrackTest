package com.cuvelo.beetrackdispatchtracktest.di;

import android.content.Context;

import androidx.room.Room;

import com.cuvelo.beetrackdispatchtracktest.data.LocalBitcoinWalletAddressDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.LocalBitcoinWalletBalanceDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.db.AddressDao;
import com.cuvelo.beetrackdispatchtracktest.data.db.BeetrackDispatchtrackDatabase;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressEntityToDomainDataMapper;
import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {

    private static final String BEETRACK_DISPATCHTRACK_DATABASE_NAME = "BEETRACK_DISPATCHTRACK_DATABASE_NAME";

    @Singleton
    @Provides
    public BeetrackDispatchtrackDatabase provideRoom(@ApplicationContext Context context){
        return Room.databaseBuilder(context, BeetrackDispatchtrackDatabase.class, BEETRACK_DISPATCHTRACK_DATABASE_NAME).build();
    }

    @Singleton
    @Provides
    public AddressDao provideAddressDao(BeetrackDispatchtrackDatabase db){
        return db.addressDao();
    }

    @Provides
    @Singleton
    public LocalBitcoinWalletAddressDataSource provideLocalBitcoinWalletAddressDataSource(AddressDao addressDao,
                                                                                          AddressEntityToDomainDataMapper addressEntityDataMapper,
                                                                                          AddressDomainToEntityDataMapper addressDomainDataMapper){
        return new LocalBitcoinWalletAddressDataSourceImpl(addressDao, addressEntityDataMapper, addressDomainDataMapper);
    }

    @Provides
    @Singleton
    public LocalBitcoinWalletBalanceDataSource provideLocalBitcoinWalletBalanceDataSource(){
        return new LocalBitcoinWalletBalanceDataSourceImpl();
    }

}