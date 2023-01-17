package com.cuvelo.beetrackdispatchtracktest.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AddressModel implements Parcelable {

    @SerializedName("private") public String privateKeyPair;
    @SerializedName("public") public String publicKeyPair;
    @SerializedName("address") public String address;
    @SerializedName("wif") public String wif;

    public AddressModel(String privateKeyPair, String publicKeyPair, String address, String wif) {
        this.privateKeyPair = privateKeyPair;
        this.publicKeyPair = publicKeyPair;
        this.address = address;
        this.wif = wif;
    }

    public AddressModel(Parcel parcel) {
        this.privateKeyPair = parcel.readString();
        this.publicKeyPair = parcel.readString();
        this.address = parcel.readString();
        this.wif = parcel.readString();
    }

    public static final Creator<AddressModel> CREATOR = new Creator<AddressModel>() {
        @Override
        public AddressModel createFromParcel(Parcel in) {
            return new AddressModel(in);
        }

        @Override
        public AddressModel[] newArray(int size) {
            return new AddressModel[size];
        }
    };

    public String getPrivateKeyPair() {
        return privateKeyPair;
    }

    public void setPrivateKeyPair(String privateKeyPair) {
        this.privateKeyPair = privateKeyPair;
    }

    public String getPublicKeyPair() {
        return publicKeyPair;
    }

    public void setPublicKeyPair(String publicKeyPair) {
        this.publicKeyPair = publicKeyPair;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWif() {
        return wif;
    }

    public void setWif(String wif) {
        this.wif = wif;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(privateKeyPair);
        parcel.writeString(publicKeyPair);
        parcel.writeString(address);
        parcel.writeString(wif);
    }
}
