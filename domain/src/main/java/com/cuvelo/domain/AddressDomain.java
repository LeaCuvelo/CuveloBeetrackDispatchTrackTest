package com.cuvelo.domain;

public class AddressDomain {

    public String privateKeyPair;
    public String publicKeyPair;
    public String address;
    public String wif;

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
}