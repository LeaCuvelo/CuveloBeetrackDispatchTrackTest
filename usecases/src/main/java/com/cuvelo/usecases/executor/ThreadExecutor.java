package com.cuvelo.usecases.executor;

import java.util.concurrent.Executor;

/**
 * Thread executor
 * Implementation will execute the
 * {@link com.cuvelo.usecases.interactor.BaseUseCase} out ot the UI Thread.*/
public interface ThreadExecutor extends Executor {
}
