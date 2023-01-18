package com.cuvelo.usecases.interactor;

import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase<T> {

    protected final ThreadExecutor mThreadExecutor;
    protected final PostExecutionThread mPostExecutionThread;
    protected Disposable mSubscription = Disposables.empty();

    public BaseUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutionThread = postExecutionThread;
    }

    protected abstract Observable<T> buildUseCaseObservable();

    public void unsubscribe(){
        if(!mSubscription.isDisposed()){
            mSubscription.dispose();
        }
    }

    public void execute(DisposableObserver<T> useCaseSubscriber){
        if(!mSubscription.isDisposed()){
            mSubscription.dispose();
        }

        mSubscription = (DisposableObserver<T>) buildUseCaseObservable()
                .subscribeOn(Schedulers.from(mThreadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribeWith(useCaseSubscriber);
    }

}
