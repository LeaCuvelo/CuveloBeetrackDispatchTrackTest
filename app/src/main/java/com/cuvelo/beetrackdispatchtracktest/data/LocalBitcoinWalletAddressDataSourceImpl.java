package com.cuvelo.beetrackdispatchtracktest.data;

import com.cuvelo.beetrackdispatchtracktest.data.db.AddressDao;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressDomainToEntityDataMapper;
import com.cuvelo.beetrackdispatchtracktest.data.mappers.AddressEntityToDomainDataMapper;
import com.cuvelo.data.datasources.LocalBitcoinWalletAddressDataSource;
import com.cuvelo.domain.AddressDomain;

import io.reactivex.Observable;

public class LocalBitcoinWalletAddressDataSourceImpl implements LocalBitcoinWalletAddressDataSource {

    private String TAG = "LocalBitcoinWalletAddressDataSourceImpl";
    private final AddressDao addressDao;
    private final AddressEntityToDomainDataMapper addressEntityDataMapper;
    private final AddressDomainToEntityDataMapper addressDomainDataMapper;


    public LocalBitcoinWalletAddressDataSourceImpl(AddressDao addressDao,
                                                   AddressEntityToDomainDataMapper addressEntityDataMapper,
                                                   AddressDomainToEntityDataMapper addressDomainDataMapper) {
        this.addressDao = addressDao;
        this.addressEntityDataMapper = addressEntityDataMapper;
        this.addressDomainDataMapper = addressDomainDataMapper;
    }

    @Override
    public Observable<AddressDomain> getBitcoinWalletAddress() {
        return Observable.just(addressEntityDataMapper.transform(addressDao.getBtcAddress()));
    }

    @Override
    public void saveBitcoinWalletAddress(AddressDomain addressDomain) {
        addressDao.insert(addressDomainDataMapper.transform(addressDomain));
    }
}