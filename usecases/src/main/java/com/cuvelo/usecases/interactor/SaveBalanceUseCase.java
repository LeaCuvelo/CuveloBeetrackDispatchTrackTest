package com.cuvelo.usecases.interactor;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import java.util.concurrent.Callable;

import io.reactivex.Completable;

public class SaveBalanceUseCase extends CompletableUseCase{

    private final BitcoinWalletRepository mBitcoinWalletRepository;
    private BalanceDomain balanceDomain;

    public SaveBalanceUseCase(
            ThreadExecutor threadExecutor,
            PostExecutionThread postExecutionThread,
            BitcoinWalletRepository bitcoinWalletRepository) {
        super(threadExecutor, postExecutionThread);
        this.mBitcoinWalletRepository = bitcoinWalletRepository;
    }

    public void setBalanceDomain(BalanceDomain balanceDomain) {
        this.balanceDomain = balanceDomain;
    }

    //TODO return values to success or error
    //TODO implement handle excpeption
    @Override
    protected Completable buildUseCaseObservable() {

        return Completable.fromCallable(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                mBitcoinWalletRepository.saveBalance(balanceDomain);
                return this;
            }
        });
    }
}
