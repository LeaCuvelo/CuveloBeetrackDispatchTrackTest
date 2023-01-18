package com.cuvelo.usecases.interactor;

import io.reactivex.observers.DisposableObserver;

public abstract class DefaultSubscriber<T> extends DisposableObserver<T> {

    @Override
    public void onError(Throwable e) {}

    protected void onCompleted(){}

    @Override
    public void onComplete() {
        onCompleted();
    }

    @Override
    public void onNext(T t) {}

}