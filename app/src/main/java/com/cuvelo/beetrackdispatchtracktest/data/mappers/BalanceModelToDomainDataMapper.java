package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.model.BalanceModel;
import com.cuvelo.domain.BalanceDomain;

import java.text.DecimalFormat;

public class BalanceModelToDomainDataMapper implements Transformer<BalanceDomain, BalanceModel> {

    private final int SATOSHIS_FACTOR_CONVERTION = 100000000;

    @Override
    public BalanceDomain transform(BalanceModel model) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(20);

        BalanceDomain balanceDomain = new BalanceDomain();
        balanceDomain.address = model.address;
        balanceDomain.balance = decimalFormat.format((double) model.balance / SATOSHIS_FACTOR_CONVERTION);
        balanceDomain.unconfirmedBalance =  decimalFormat.format((double) model.unconfirmedBalance / SATOSHIS_FACTOR_CONVERTION);
        balanceDomain.finalBalance = decimalFormat.format((double) model.finalBalance / SATOSHIS_FACTOR_CONVERTION );
        return balanceDomain;
    }
}