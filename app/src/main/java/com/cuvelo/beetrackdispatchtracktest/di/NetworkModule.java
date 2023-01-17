package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.beetrackdispatchtracktest.data.BitcoinWalletRemoteServer;
import com.cuvelo.beetrackdispatchtracktest.data.RemoteBitcoinWalletAddressDataSourceImpl;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressModelDataMapper;
import com.cuvelo.beetrackdispatchtracktest.ui.UIThread;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.usecases.executor.JobExecutor;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
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

    //TODO move to Concurrent Module
    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }







}
