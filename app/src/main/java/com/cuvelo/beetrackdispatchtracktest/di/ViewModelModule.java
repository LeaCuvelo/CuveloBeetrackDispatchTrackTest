package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import com.cuvelo.usecases.interactor.FindBalanceByAddressUseCase;
import com.cuvelo.usecases.interactor.GenerateAddressUseCase;
import com.cuvelo.usecases.interactor.SaveAddressUseCase;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ViewModelComponent;

@Module
@InstallIn(ViewModelComponent.class)
public class ViewModelModule {

    @Provides
    public GenerateAddressUseCase provideGenerateAddressUseCase(ThreadExecutor threadExecutor,
                                                                PostExecutionThread postExecutionThread,
                                                                BitcoinWalletRepository bitcoinWalletRepository){
        return new GenerateAddressUseCase(threadExecutor, postExecutionThread, bitcoinWalletRepository);
    }

    @Provides
    public SaveAddressUseCase provideSaveAddressUseCase(ThreadExecutor threadExecutor,
                                                        PostExecutionThread postExecutionThread,
                                                        BitcoinWalletRepository bitcoinWalletRepository){
        return new SaveAddressUseCase(threadExecutor, postExecutionThread, bitcoinWalletRepository);
    }

    @Provides
    public FindBalanceByAddressUseCase provideFindBalanceByAddressUseCase(ThreadExecutor threadExecutor,
                                                                          PostExecutionThread postExecutionThread,
                                                                          BitcoinWalletRepository bitcoinWalletRepository){
        return new FindBalanceByAddressUseCase(threadExecutor, postExecutionThread, bitcoinWalletRepository);
    }

}