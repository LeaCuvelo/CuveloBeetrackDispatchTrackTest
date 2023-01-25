package com.cuvelo.domain;

import java.util.List;

public class FullBalanceDomain extends BalanceDomain {

    public List<BitcoinTransactionDomain> transactions;

    public List<BitcoinTransactionDomain> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BitcoinTransactionDomain> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass() == obj.getClass()){
            FullBalanceDomain object = (FullBalanceDomain) obj;
            return this.address.equals(object.address) && this.balance.equals(object.balance)
                    && this.unconfirmedBalance.equals(object.unconfirmedBalance)
                    && this.finalBalance.equals(object.finalBalance)
                    && transactions.equals(object.transactions);
        }
        return false;
    }

}