package com.cuvelo.beetrackdispatchtracktest.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.cuvelo.beetrackdispatchtracktest.data.db.converters.Converters;
import com.cuvelo.beetrackdispatchtracktest.data.db.entities.BalanceEntity;
import com.cuvelo.beetrackdispatchtracktest.data.db.entities.FullBalanceEntity;

@Database(entities = {BalanceEntity.class, FullBalanceEntity.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class BeetrackDispatchtrackDatabase  extends RoomDatabase {
    public abstract BalanceDao balanceDao();
    public abstract FullBalanceDao fullBalanceDao();
}
