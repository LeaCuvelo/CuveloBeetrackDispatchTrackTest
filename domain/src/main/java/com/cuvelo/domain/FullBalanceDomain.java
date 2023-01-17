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
}
