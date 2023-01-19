package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.db.entities.AddressEntity;
import com.cuvelo.domain.AddressDomain;

public class AddressDomainDataMapper implements  Transformer<AddressEntity , AddressDomain>{

    @Override
    public AddressEntity transform(AddressDomain domain) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.address = domain.address;
        addressEntity.privateKeyPair = domain.privateKeyPair;
        addressEntity.publicKeyPair = domain.publicKeyPair;
        return addressEntity;
    }
}
