package com.cuvelo.beetrackdispatchtracktest.data.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class BalanceEntity {

    @PrimaryKey
    @NotNull
    public String address;

    @ColumnInfo(name = "balance")
    public String balance;

    @ColumnInfo(name = "unconfirmedBalance")
    public String unconfirmedBalance;

    @ColumnInfo(name = "final_balance")
    public String finalBalance;

}