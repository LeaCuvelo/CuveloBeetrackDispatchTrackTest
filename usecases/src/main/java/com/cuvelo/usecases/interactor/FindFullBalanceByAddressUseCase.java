package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.FullBalanceDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Observable;

public class FindFullBalanceByAddressUseCase extends UseCase{

    private final BitcoinWalletRepository mBitcoinWalletRepository;
    private String btcWalletAddress;

    public FindFullBalanceByAddressUseCase(
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
    protected Observable<FullBalanceDomain> buildUseCaseObservable() {
        return mBitcoinWalletRepository.getFullBalanceByAddressFromApi(btcWalletAddress);
    }

}
