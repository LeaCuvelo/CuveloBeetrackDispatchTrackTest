package com.cuvelo.data.datasources;

import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;

public interface RemoteBitcoinWalletBalanceDataSource {
     Observable<BalanceDomain> getBalance(String address);
     Observable<FullBalanceDomain> getFullBalance(String address);
}
