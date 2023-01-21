package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceModelDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.model.AddressModel;
import com.cuvelo.beetrackdispatchtracktest.data.model.BalanceModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BitcoinWalletRemoteServer {

    @POST("addrs")
    Observable<AddressModel> generateBitcoinAddress();

    @GET("{address}/balance")
    Observable<BalanceModel> getBitcoinWalletBalance(@Path("address") String address);

}

