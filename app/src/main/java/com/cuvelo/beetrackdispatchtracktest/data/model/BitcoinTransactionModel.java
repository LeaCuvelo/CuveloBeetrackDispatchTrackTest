package com.cuvelo.beetrackdispatchtracktest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class BitcoinTransactionModel implements Parcelable {

    @SerializedName("total")
    public int total;

    @SerializedName("confirmed")
    public String timeStampConfirmed;

    protected BitcoinTransactionModel(Parcel in) {
        total = in.readInt();
        timeStampConfirmed = in.readString();
    }

    public static final Creator<BitcoinTransactionModel> CREATOR = new Creator<BitcoinTransactionModel>() {
        @Override
        public BitcoinTransactionModel createFromParcel(Parcel in) { return new BitcoinTransactionModel(in); }

        @Override
        public BitcoinTransactionModel[] newArray(int size) { return new BitcoinTransactionModel[size]; }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(total);
        dest.writeString(timeStampConfirmed);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTimeStampConfirmed() {
        return timeStampConfirmed;
    }

    public void setTimeStampConfirmed(String timeStampConfirmed) {
        this.timeStampConfirmed = timeStampConfirmed;
    }
}
