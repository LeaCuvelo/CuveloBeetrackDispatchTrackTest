package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.BalanceEntity;
import com.cuvelo.domain.BalanceDomain;

public class BalanceEntityToDomainDataMapper implements Transformer<BalanceDomain, BalanceEntity> {

    @Override
    public BalanceDomain transform(BalanceEntity entity) {
        BalanceDomain balanceDomain = new BalanceDomain();
        balanceDomain.address = entity.address;
        balanceDomain.balance = entity.balance;
        balanceDomain.unconfirmedBalance = entity.unconfirmedBalance;
        balanceDomain.finalBalance = entity.finalBalance;
        return balanceDomain;
    }
}