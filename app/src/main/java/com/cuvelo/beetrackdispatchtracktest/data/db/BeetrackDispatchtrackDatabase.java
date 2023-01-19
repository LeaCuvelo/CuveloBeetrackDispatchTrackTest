package com.cuvelo.beetrackdispatchtracktest.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.AddressEntity;

@Database(entities = {AddressEntity.class}, version = 1)
public abstract class BeetrackDispatchtrackDatabase  extends RoomDatabase {
    public abstract AddressDao addressDao();
}
