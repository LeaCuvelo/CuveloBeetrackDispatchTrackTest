package com.cuvelo.beetrackdispatchtracktest.data.db.entities;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

//TODO delete this entity and related files! we are using shared preff
@Entity
public class AddressEntity {

    @PrimaryKey
    @NotNull
    public String address;

    //TODO maybe this two following columns should be deleted
    @ColumnInfo(name = "private_key_pair")
    public String privateKeyPair;

    @ColumnInfo(name = "public_key_pair")
    public String publicKeyPair;

}
