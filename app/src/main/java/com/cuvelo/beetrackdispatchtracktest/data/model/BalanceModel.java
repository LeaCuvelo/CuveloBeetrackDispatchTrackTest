package com.cuvelo.beetrackdispatchtracktest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class BalanceModel implements Parcelable {


    @SerializedName("address") public String address;
    @SerializedName("balance")  public int balance;
    @SerializedName("unconfirmed_balance") public int unconfirmedBalance;
    @SerializedName("final_balance") public int finalBalance;


    protected BalanceModel(Parcel parcel) {
        address = parcel.readString();
        balance = parcel.readInt();
        unconfirmedBalance = parcel.readInt();
        finalBalance = parcel.readInt();
    }

    public static final Creator<BalanceModel> CREATOR = new Creator<BalanceModel>() {
        @Override
        public BalanceModel createFromParcel(Parcel in) {return new BalanceModel(in);}

        @Override
        public BalanceModel[] newArray(int size) {return new BalanceModel[size];}
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(int unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public int getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(int finalBalance) {
        this.finalBalance = finalBalance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeInt(balance);
        dest.writeInt(unconfirmedBalance);
        dest.writeInt(finalBalance);
    }


}
