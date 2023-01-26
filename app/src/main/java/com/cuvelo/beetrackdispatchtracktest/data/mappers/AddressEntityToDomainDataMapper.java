package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.AddressEntity;
import com.cuvelo.domain.AddressDomain;

public class AddressEntityToDomainDataMapper implements  Transformer<AddressDomain, AddressEntity>{

    @Override
    public AddressDomain transform(AddressEntity entity) {
        AddressDomain addressDomain = new AddressDomain();
        addressDomain.address = entity.address;
        addressDomain.privateKeyPair = entity.privateKeyPair;
        addressDomain.publicKeyPair = entity.publicKeyPair;
        return addressDomain;
    }
}