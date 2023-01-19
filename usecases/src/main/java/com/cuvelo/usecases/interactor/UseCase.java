package com.cuvelo.usecases.interactor;

import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T> extends BaseUseCase{

    protected final PostExecutionThread mPostExecutionThread;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor);
        this.mPostExecutionThread = postExecutionThread;
    }

    protected abstract Observable<T> buildUseCaseObservable();


    public void execute(DisposableObserver<T> useCaseSubscriber){
        if(!subscription.isDisposed()){
            subscription.dispose();
        }

        subscription = (DisposableObserver<T>) buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(mPostExecutionThread.getScheduler())
                .subscribeWith(useCaseSubscriber);
    }

}
