package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.db.BalanceDao;
import com.cuvelo.beetrackdispatchtracktest.data.db.FullBalanceDao;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.BalanceEntityToDomainDataMapper;
import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;

public class LocalBitcoinWalletBalanceDataSourceImpl implements LocalBitcoinWalletBalanceDataSource {

    private final BalanceDao balanceDao;
    private final FullBalanceDao fullBalanceDao;
    private final BalanceDomainToEntityDataMapper balanceDomainToEntityDataMapper;
    private final BalanceEntityToDomainDataMapper balanceEntityToDomainDataMapper;


    public LocalBitcoinWalletBalanceDataSourceImpl(BalanceDao balanceDao,
                                                   FullBalanceDao fullBalanceDao,
                                                   BalanceDomainToEntityDataMapper balanceDomainToEntityDataMapper,
                                                   BalanceEntityToDomainDataMapper balanceEntityToDomainDataMapper) {
        this.balanceDao = balanceDao;
        this.fullBalanceDao = fullBalanceDao;
        this.balanceDomainToEntityDataMapper = balanceDomainToEntityDataMapper;
        this.balanceEntityToDomainDataMapper = balanceEntityToDomainDataMapper;
    }


    @Override
    public Observable getBalance(String address) {
        return Observable.just(balanceEntityToDomainDataMapper.transform(balanceDao.getBalance()));
    }

    @Override
    public Observable getFullBalance(String address) {
        return null;
    }

    @Override
    public void clearBalanceInDataBase() {
        balanceDao.deleteAll();
    }

    @Override
    public void saveBalance(BalanceDomain balanceDomain) {
        balanceDao.insert(balanceDomainToEntityDataMapper.transform(balanceDomain));
    }

    @Override
    public void clearFullBalanceInDataBase() {

    }

    @Override
    public void saveFullBalance(FullBalanceDomain fullBalanceDomain) {

    }
}