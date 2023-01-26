package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Observable;

public class FindBalanceByAddressUseCase extends UseCase{

    private final BitcoinWalletRepository mBitcoinWalletRepository;
    private String btcWalletAddress;

    public FindBalanceByAddressUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            BitcoinWalletRepository bitcoinWalletRepository) {
        super(threadExecutor, postExecutionThread);
        this.mBitcoinWalletRepository = bitcoinWalletRepository;
    }

    public void setBtcWalletAddress(String btcWalletAddress) {
        this.btcWalletAddress = btcWalletAddress;
    }

    @Override
    protected Observable<BalanceDomain> buildUseCaseObservable() {
        return mBitcoinWalletRepository.getBalanceByAddressFromApi(btcWalletAddress);
    }

}