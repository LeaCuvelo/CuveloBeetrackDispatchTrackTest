package com.cuvelo.usecases.executor;

import com.cuvelo.usecases.interactor.UseCase;

import java.util.concurrent.Executor;

/**
 * Thread executor
 * Implementation will execute the
 * {@link UseCase} out ot the UI Thread.*/
public interface ThreadExecutor extends Executor {
}
