package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.model.AddressModel;
import com.cuvelo.beetrackdispatchtracktest.data.model.BalanceModel;
import com.cuvelo.beetrackdispatchtracktest.data.model.FullBalanceModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BitcoinWalletRemoteServer {

    @POST("addrs")
    Observable<AddressModel> generateBitcoinAddress();

    @GET("addrs/{address}/balance")
    Observable<BalanceModel> getBitcoinWalletBalance(@Path("address") String address);

    @GET("addrs/{address}/full")
    Observable<FullBalanceModel> getBitcoinWalletFullBalance(@Path("address") String address);

}

