package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressModelDataMapper;

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
    public AddressModelDataMapper provideAddressModelDataMapper(){
        return new AddressModelDataMapper();
    }

}
