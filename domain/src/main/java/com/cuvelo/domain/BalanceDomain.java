package com.cuvelo.domain;

public class BalanceDomain {

    public String address;
    public int balance;
    public int unconfirmedBalance;
    public int finalBalance;

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
}
