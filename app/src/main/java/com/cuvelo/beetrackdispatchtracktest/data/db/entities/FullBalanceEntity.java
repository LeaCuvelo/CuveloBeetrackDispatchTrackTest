package com.cuvelo.beetrackdispatchtracktest.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.List;

@Entity
public class FullBalanceEntity extends BalanceEntity{

    //TODO check why converter isn't working
    /*@ColumnInfo(name = "transactions")
    public List<BitcoinTransactionEntity> transactions;*/
}
