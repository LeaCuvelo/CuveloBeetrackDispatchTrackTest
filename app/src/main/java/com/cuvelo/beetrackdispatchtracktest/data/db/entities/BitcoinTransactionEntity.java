package com.cuvelo.beetrackdispatchtracktest.data.db.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

@Entity
public class BitcoinTransactionEntity {

    @PrimaryKey
    @NotNull
    public String timestampConfirmed;

    @ColumnInfo(name = "total")
    public String total;

    @ColumnInfo(name = "unconfirmed")
    public Boolean unconfirmed;

}