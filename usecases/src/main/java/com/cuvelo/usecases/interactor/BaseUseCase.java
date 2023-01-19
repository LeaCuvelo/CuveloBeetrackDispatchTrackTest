package com.cuvelo.usecases.interactor;

import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

public abstract class BaseUseCase {

    protected final ThreadExecutor threadExecutor;

    protected Disposable subscription = Disposables.empty();

    public BaseUseCase(ThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
    }

    public void unsubscribe(){
        if(!subscription.isDisposed()){
            subscription.dispose();
        }
    }


}
