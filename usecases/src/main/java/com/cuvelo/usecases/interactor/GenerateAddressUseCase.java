package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.GenerateBitcoinAddressRepository;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Observable;


public class GenerateAddressUseCase extends BaseUseCase {

    private final GenerateBitcoinAddressRepository mGenerateBitcoinAddressRepository;


    //todo emitir un primer valor
    //TODO reemplazar observable con flowable

    public GenerateAddressUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            GenerateBitcoinAddressRepository mGenerateBitcoinAddressRepository) {
        super(threadExecutor, postExecutionThread);
        this.mGenerateBitcoinAddressRepository = mGenerateBitcoinAddressRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return mGenerateBitcoinAddressRepository.generateBitcoinWalletAddressFromApi();
    }


}