package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import com.cuvelo.usecases.interactor.DefaultSubscriber;
import com.cuvelo.usecases.interactor.UseCase;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.doAnswer;

import org.mockito.Matchers;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class TestHelper {

    public static void prepareExecutorForTest(ThreadExecutor threadExecutor,
                                              PostExecutionThread postExecutionThread){


        doAnswer(invocation -> AndroidSchedulers.mainThread())
                .when(postExecutionThread).getScheduler();

        doAnswer(invocation -> {
            Runnable command = (Runnable) invocation.getArguments()[0];
            command.run();
            return null;
        }).when(threadExecutor).execute(anyObject());
    }

    public static void configureUseCaseSuccess(UseCase useCase, Object response){
        doAnswer(invocation -> {
            DefaultSubscriber subscriber = (DefaultSubscriber) invocation.getArguments()[0];
            subscriber.onNext(response);
            subscriber.onComplete();
            return null;
        }).when(useCase).execute(Matchers.any(DefaultSubscriber.class));
    }

    public static void configureUseCaseError(UseCase useCase, Throwable throwable){
        doAnswer(invocation -> {
            DefaultSubscriber subscriber = (DefaultSubscriber) invocation.getArguments()[0];
            subscriber.onError(throwable);
            return null;
        }).when(useCase).execute(Matchers.any(DefaultSubscriber.class));
    }

}
