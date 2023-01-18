package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.beetrackdispatchtracktest.data.BitcoinWalletRemoteServer;
import com.cuvelo.beetrackdispatchtracktest.data.RemoteBitcoinWalletAddressDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.RemoteBitcoinWalletBalanceDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressModelDataMapper;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    public String provideBaseUrl() { return "https://api.blockcypher.com/v1/btc/test3/"; }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named("baseUrl") String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public BitcoinWalletRemoteServer provideBitcoinWalletRemoteServer(Retrofit retrofit){
        return retrofit.create(BitcoinWalletRemoteServer.class);
    }

    @Provides
    @Singleton
    public RemoteBitcoinWalletAddressDataSource provideRemoteBitcoinWalletAddressDataSource(BitcoinWalletRemoteServer bitcoinWalletRemoteServer,
                                                                                            AddressModelDataMapper addressModelDataMapper ){
        return new RemoteBitcoinWalletAddressDataSourceImpl(bitcoinWalletRemoteServer, addressModelDataMapper);
    }

    //TODO add arguments when implements feature
    @Provides
    @Singleton
    public RemoteBitcoinWalletBalanceDataSource provideRemoteBitcoinWalletBalanceDataSource(){
        return new RemoteBitcoinWalletBalanceDataSourceImpl();
    }

}