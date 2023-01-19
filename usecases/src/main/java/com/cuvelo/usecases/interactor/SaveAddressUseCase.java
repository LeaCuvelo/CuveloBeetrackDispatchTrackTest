package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Completable;

public class SaveAddressUseCase  extends CompletableUseCase {

    private final BitcoinWalletRepository mBitcoinWalletRepository;
    private AddressDomain addressDomain;

    public SaveAddressUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            BitcoinWalletRepository bitcoinWalletRepository) {
        super(threadExecutor, postExecutionThread);
        this.mBitcoinWalletRepository = bitcoinWalletRepository;
    }

    public void setAddressDomain(AddressDomain addressDomain) {
        this.addressDomain = addressDomain;
    }

    //TODO return values to success or error
    @Override
    protected Completable buildUseCaseObservable() {
       mBitcoinWalletRepository.saveBitcoinWalletAddress(addressDomain);
       return null;
    }
}
