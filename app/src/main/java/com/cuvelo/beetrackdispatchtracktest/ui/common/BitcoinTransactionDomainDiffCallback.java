package com.cuvelo.beetrackdispatchtracktest.ui.common;

import androidx.recyclerview.widget.DiffUtil;

import com.cuvelo.domain.BitcoinTransactionDomain;

import java.util.List;

public class BitcoinTransactionDomainDiffCallback extends DiffUtil.Callback {

    private List<BitcoinTransactionDomain> newBitcoinTransactionDomainList;
    private List<BitcoinTransactionDomain> oldBitcoinTransactionDomainList;

    public void setNewBitcoinTransactionDomainList(List<BitcoinTransactionDomain> newBitcoinTransactionDomainList) {
        this.newBitcoinTransactionDomainList = newBitcoinTransactionDomainList;
    }

    public void setOldBitcoinTransactionDomainList(List<BitcoinTransactionDomain> oldBitcoinTransactionDomainList) {
        this.oldBitcoinTransactionDomainList = oldBitcoinTransactionDomainList;
    }

    @Override
    public int getOldListSize() {
        return oldBitcoinTransactionDomainList.size();
    }

    @Override
    public int getNewListSize() {
        return newBitcoinTransactionDomainList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        BitcoinTransactionDomain oldBitcoinTransactionDomain = oldBitcoinTransactionDomainList.get(oldItemPosition);
        BitcoinTransactionDomain newBitcoinTransactionDomain = newBitcoinTransactionDomainList.get(newItemPosition);

        return oldBitcoinTransactionDomain.getTimestampConfirmed().equals(newBitcoinTransactionDomain.getTimestampConfirmed());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        BitcoinTransactionDomain oldBitcoinTransactionDomain = oldBitcoinTransactionDomainList.get(oldItemPosition);
        BitcoinTransactionDomain newBitcoinTransactionDomain = newBitcoinTransactionDomainList.get(newItemPosition);

        return oldBitcoinTransactionDomain.getTimestampConfirmed().equals(newBitcoinTransactionDomain.getTimestampConfirmed())
                && oldBitcoinTransactionDomain.getTotal()==newBitcoinTransactionDomain.getTotal();
    }

}