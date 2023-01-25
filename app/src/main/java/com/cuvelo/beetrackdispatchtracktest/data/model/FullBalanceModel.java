package com.cuvelo.beetrackdispatchtracktest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullBalanceModel extends BalanceModel implements Parcelable {

    @SerializedName("txs")
    public List<BitcoinTransactionModel> transactions;

    protected FullBalanceModel(Parcel parcel) {
        super(parcel);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeInt(balance);
        dest.writeInt(unconfirmedBalance);
        dest.writeInt(finalBalance);
        dest.writeList(transactions);
    }

    public List<BitcoinTransactionModel> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<BitcoinTransactionModel> transactions) {
        this.transactions = transactions;
    }
}
