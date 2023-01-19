package com.cuvelo.usecases.interactor;

import io.reactivex.observers.DisposableCompletableObserver;

public class DefaultCompletableSubscriber extends DisposableCompletableObserver {
    @Override
    public void onComplete() {
        onCompleted();
    }

    protected void onCompleted(){

    }

    @Override
    public void onError(Throwable e) {

    }
}
