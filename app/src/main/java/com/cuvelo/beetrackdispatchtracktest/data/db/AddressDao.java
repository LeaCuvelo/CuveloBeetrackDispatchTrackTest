package com.cuvelo.beetrackdispatchtracktest.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.AddressEntity;

@Dao
public interface AddressDao {

    //TODO change this query, only one address will be stored in DB
    @Query("SELECT * FROM addressentity")
    AddressEntity getBtcAddress();

    @Insert
    void insert(AddressEntity... addressEntities);

    @Delete
    void delete(AddressEntity addressEntity);

}