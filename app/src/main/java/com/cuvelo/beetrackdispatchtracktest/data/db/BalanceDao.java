package com.cuvelo.beetrackdispatchtracktest.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.BalanceEntity;


@Dao
public interface BalanceDao {

    @Query("SELECT * FROM balanceentity")
    BalanceEntity getBalance();

    @Insert
    void insert(BalanceEntity... balanceEntities);

    @Query("DELETE FROM balanceentity")
    void deleteAll();

}