package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceModelToDomainDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.FullBalanceModelToDomainDataMapper;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;

public class RemoteBitcoinWalletBalanceDataSourceImpl implements RemoteBitcoinWalletBalanceDataSource {

    private String TAG = "RemoteBitcoinWalletBalanceDataSourceImpl";

    private final BitcoinWalletRemoteServer bitcoinWalletRemoteServer;
    private final BalanceModelToDomainDataMapper balanceModelDataMapper;
    private final FullBalanceModelToDomainDataMapper fullBalanceModelToDomainDataMapper;

    public RemoteBitcoinWalletBalanceDataSourceImpl(BitcoinWalletRemoteServer bitcoinWalletRemoteServer,
                                                    BalanceModelToDomainDataMapper balanceModelDataMapper,
                                                    FullBalanceModelToDomainDataMapper fullBalanceModelToDomainDataMapper) {
        this.bitcoinWalletRemoteServer = bitcoinWalletRemoteServer;
        this.balanceModelDataMapper = balanceModelDataMapper;
        this.fullBalanceModelToDomainDataMapper = fullBalanceModelToDomainDataMapper;
    }

    @Override
    public Observable<BalanceDomain> getBalance(String address) {
        return bitcoinWalletRemoteServer.getBitcoinWalletBalance(address).map(balanceModelDataMapper::transform);
    }

    @Override
    public Observable<FullBalanceDomain> getFullBalance(String address) {
        return bitcoinWalletRemoteServer.getBitcoinWalletFullBalance(address).map(fullBalanceModelToDomainDataMapper::transform);
    }
}