package com.cuvelo.usecases.interactor;

import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class CompletableUseCase extends BaseUseCase {

    protected final PostExecutionThread postExecutionThread;

    public CompletableUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor);
        this.postExecutionThread = postExecutionThread;
    }


    protected abstract Completable buildUseCaseObservable();

    public void execute(DisposableCompletableObserver useCaseSubscriber){
        if(!subscription.isDisposed()){
            subscription.dispose();
        }

        subscription = buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribeWith(useCaseSubscriber);

    }
}