package com.cuvelo.data.datasources;

import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;

public interface LocalBitcoinWalletBalanceDataSource {
    Observable<BalanceDomain> getBalance(String address);
    Observable<FullBalanceDomain> getFullBalance(String address);
    void clearBalanceInDataBase();
    void saveBalance(BalanceDomain balanceDomain);
    void clearFullBalanceInDataBase();
    void saveFullBalance(FullBalanceDomain fullBalanceDomain);
}