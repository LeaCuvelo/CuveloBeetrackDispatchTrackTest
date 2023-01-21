package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.model.BalanceModel;
import com.cuvelo.domain.BalanceDomain;

public class BalanceModelDataMapper implements Transformer<BalanceDomain, BalanceModel> {

    @Override
    public BalanceDomain transform(BalanceModel model) {
        BalanceDomain balanceDomain = new BalanceDomain();
        balanceDomain.address = model.address;
        balanceDomain.balance = model.balance;
        balanceDomain.unconfirmedBalance = model.unconfirmedBalance;
        balanceDomain.finalBalance = model.finalBalance;
        return balanceDomain;
    }
}