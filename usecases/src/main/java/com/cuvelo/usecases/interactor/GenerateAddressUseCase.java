package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Observable;


public class GenerateAddressUseCase extends BaseUseCase {

    private final BitcoinWalletRepository mBitcoinWalletRepository;

    //TODO emitir un primer valo
    //TODO reemplazar observable con flowable

    public GenerateAddressUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            BitcoinWalletRepository bitcoinWalletRepository) {
        super(threadExecutor, postExecutionThread);
        this.mBitcoinWalletRepository = bitcoinWalletRepository;
    }

    @Override
    protected Observable<AddressDomain> buildUseCaseObservable() {
        return mBitcoinWalletRepository.generateBitcoinWalletAddressFromApi();
    }

}