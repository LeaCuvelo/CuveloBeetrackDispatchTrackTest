package com.cuvelo.beetrackdispatchtracktest.di;

import com.cuvelo.data.repositories.GenerateBitcoinAddressRepository;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import com.cuvelo.usecases.interactor.GenerateAddressUseCase;

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
                                                                GenerateBitcoinAddressRepository repository){
        return new GenerateAddressUseCase(threadExecutor, postExecutionThread, repository);
    }
}
