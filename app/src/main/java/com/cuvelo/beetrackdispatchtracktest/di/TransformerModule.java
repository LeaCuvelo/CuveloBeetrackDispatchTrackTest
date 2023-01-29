package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressEntityToDomainDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressModelToDomainDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceEntityToDomainDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceModelToDomainDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.FullBalanceModelToDomainDataMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class TransformerModule {

    @Provides
    @Singleton
    public AddressModelToDomainDataMapper provideAddressModelDataMapper(){
        return new AddressModelToDomainDataMapper();
    }

    @Provides
    @Singleton
    public AddressEntityToDomainDataMapper provideAddressEntityDataMapper(){
        return new AddressEntityToDomainDataMapper();
    }

    @Provides
    @Singleton
    public AddressDomainToEntityDataMapper provideAddressDomainDataMapper(){
        return new AddressDomainToEntityDataMapper();
    }

    @Provides
    @Singleton
    public BalanceModelToDomainDataMapper provideBalanceModelDataMapper(){
        return new BalanceModelToDomainDataMapper();
    }


    @Provides
    @Singleton
    public FullBalanceModelToDomainDataMapper provideFullBalanceModelToDomainDataMapper(){
        return new FullBalanceModelToDomainDataMapper();
    }


    @Provides
    @Singleton
    public BalanceDomainToEntityDataMapper provideBalanceDomainToEntityDataMapper(){
        return new BalanceDomainToEntityDataMapper();
    }

    @Provides
    @Singleton
    public BalanceEntityToDomainDataMapper provideBalanceEntityToDomainDataMapper(){
        return new BalanceEntityToDomainDataMapper();
    }
}