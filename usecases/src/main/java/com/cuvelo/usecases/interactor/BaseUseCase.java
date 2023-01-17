package com.cuvelo.usecases.interactor;

import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase {

    protected final ThreadExecutor mThreadExecutor;
    protected final PostExecutionThread mPostExecutionThread;
    protected Disposable mSubscription = Disposables.empty();


    public BaseUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutionThread = postExecutionThread;
    }

    public void unsubscribe(){
        if(!mSubscription.isDisposed()){
            mSubscription.dispose();
        }
    }

    //TODO Refactor y ver con generics tanto para Observable y DisposableObservable
    //TODO try to generify
    //unsubscribe
    protected abstract Observable buildUseCaseObservable();

    public void execute(DisposableObserver useCaseSubscriber){
        if(!mSubscription.isDisposed()){
            mSubscription.dispose();
        }

        mSubscription = (DisposableObserver) buildUseCaseObservable()
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribeWith(useCaseSubscriber);


    }


}
