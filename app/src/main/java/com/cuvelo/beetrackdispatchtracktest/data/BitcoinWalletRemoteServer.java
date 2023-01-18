package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.model.AddressModel;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface BitcoinWalletRemoteServer {

    @POST("addrs")
    Observable<AddressModel> generateBitcoinAddress();

}