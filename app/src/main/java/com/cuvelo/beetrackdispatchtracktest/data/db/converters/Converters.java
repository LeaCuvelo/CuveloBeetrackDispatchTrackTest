package com.cuvelo.beetrackdispatchtracktest.data.db.converters;

import androidx.room.TypeConverter;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.BitcoinTransactionEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Converters {

    @TypeConverter
    public String fromBitcoinTransactionList(List<BitcoinTransactionEntity> transactions) {
        if (transactions == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<BitcoinTransactionEntity>>() {}.getType();
        return gson.toJson(transactions, type);
    }

    @TypeConverter
    public String fromBitcoinTransaction(BitcoinTransactionEntity transaction) {
        if (transaction == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<BitcoinTransactionEntity>() {}.getType();
        return gson.toJson(transaction, type);
    }

}
