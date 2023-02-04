package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.BalanceEntity;
import com.cuvelo.domain.BalanceDomain;

public class BalanceDomainToEntityDataMapper implements  Transformer<BalanceEntity, BalanceDomain> {

    @Override
    public BalanceEntity transform(BalanceDomain domain) {
        BalanceEntity balanceEntity = new BalanceEntity();
        if(domain != null){
            balanceEntity.address = domain.address;
            balanceEntity.balance = domain.balance;
            balanceEntity.unconfirmedBalance = domain.unconfirmedBalance;
            balanceEntity.finalBalance = domain.finalBalance;
        }
        else{
            balanceEntity.address = "";
            balanceEntity.balance = "";
            balanceEntity.unconfirmedBalance = "";
            balanceEntity.finalBalance = "";
        }


        return balanceEntity;
    }
}
