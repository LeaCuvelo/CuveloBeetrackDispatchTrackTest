package com.cuvelo.domain;

public class BitcoinTransactionDomain {

    private String total;
    private String timestampConfirmed;
    private boolean unconfirmed;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTimestampConfirmed() {
        return timestampConfirmed;
    }

    public void setTimestampConfirmed(String timestampConfirmed) {
        this.timestampConfirmed = timestampConfirmed;
    }

    public boolean isUnconfirmed() {
        return unconfirmed;
    }

    public void setUnconfirmed(boolean unconfirmed) {
        this.unconfirmed = unconfirmed;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass() == obj.getClass()){
            BitcoinTransactionDomain object = (BitcoinTransactionDomain) obj;
            return this.total.equals(object.total) && this.timestampConfirmed.equals(object.timestampConfirmed);
        }
        return false;
    }
}
