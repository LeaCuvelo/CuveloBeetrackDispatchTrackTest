package com.cuvelo.domain;

public class BalanceDomain {

    public String address;
    public String balance;
    public String unconfirmedBalance;
    public String finalBalance;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    public void setUnconfirmedBalance(String unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    public String getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(String finalBalance) {
        this.finalBalance = finalBalance;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass() == obj.getClass()){
            BalanceDomain object = (BalanceDomain) obj;
            return this.address.equals(object.address) && this.balance.equals(object.balance)
                    && this.unconfirmedBalance.equals(object.unconfirmedBalance)
                    && this.finalBalance.equals(object.finalBalance);
        }
        return false;
    }

}
