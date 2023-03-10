package com.cuvelo.beetrackdispatchtracktest.di;

import android.content.Context;

import androidx.room.Room;

import com.cuvelo.beetrackdispatchtracktest.data.LocalBitcoinWalletBalanceDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.db.BalanceDao;
import com.cuvelo.beetrackdispatchtracktest.data.db.BeetrackDispatchtrackDatabase;
import com.cuvelo.beetrackdispatchtracktest.data.db.FullBalanceDao;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceEntityToDomainDataMapper;
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


    @Provides
    @Singleton
    public BalanceDao provideBalanceDao(BeetrackDispatchtrackDatabase db){
        return db.balanceDao();
    }

    @Provides
    @Singleton
    public FullBalanceDao provideFullBalanceDao(BeetrackDispatchtrackDatabase db){
        return db.fullBalanceDao();
    }

    @Provides
    @Singleton
    public LocalBitcoinWalletBalanceDataSource provideLocalBitcoinWalletBalanceDataSource(BalanceDao balanceDao,
                                                                                          FullBalanceDao fullBalanceDao,
                                                                                          BalanceDomainToEntityDataMapper balanceDomainToEntityDataMapper,
                                                                                          BalanceEntityToDomainDataMapper balanceEntityToDomainDataMapper){
        return new LocalBitcoinWalletBalanceDataSourceImpl(balanceDao, fullBalanceDao, balanceDomainToEntityDataMapper, balanceEntityToDomainDataMapper);
    }

}