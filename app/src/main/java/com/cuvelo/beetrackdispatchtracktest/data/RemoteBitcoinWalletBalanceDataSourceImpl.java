package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceModelDataMapper;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.BalanceDomain;

import io.reactivex.Observable;

public class RemoteBitcoinWalletBalanceDataSourceImpl implements RemoteBitcoinWalletBalanceDataSource {

    private String TAG = "RemoteBitcoinWalletBalanceDataSourceImpl";

    private final BitcoinWalletRemoteServer bitcoinWalletRemoteServer;
    private final BalanceModelDataMapper balanceModelDataMapper;

    public RemoteBitcoinWalletBalanceDataSourceImpl(BitcoinWalletRemoteServer bitcoinWalletRemoteServer,
                                                    BalanceModelDataMapper balanceModelDataMapper) {
        this.bitcoinWalletRemoteServer = bitcoinWalletRemoteServer;
        this.balanceModelDataMapper = balanceModelDataMapper;
    }

    @Override
    public Observable<BalanceDomain> getBalance(String address) {
        return bitcoinWalletRemoteServer.getBitcoinWalletBalance(address).map(balanceModelDataMapper::transform);
    }

    @Override
    public Observable getFullBalance(String address) {
        return null;
    }
}