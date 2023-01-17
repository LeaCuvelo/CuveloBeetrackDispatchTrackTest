package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.model.AddressModel;
import com.cuvelo.domain.AddressDomain;


public class AddressModelDataMapper implements Transformer<AddressDomain, AddressModel> {

    @Override
    public AddressDomain transform(AddressModel model) {
        AddressDomain addressDomain = new AddressDomain();
        addressDomain.address = model.address;
        addressDomain.privateKeyPair = model.privateKeyPair;
        addressDomain.publicKeyPair = model.publicKeyPair;
        addressDomain.wif = model.wif;
        return addressDomain;
    }
}
