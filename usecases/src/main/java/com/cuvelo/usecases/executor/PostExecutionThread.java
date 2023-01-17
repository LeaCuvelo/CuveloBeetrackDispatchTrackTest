package com.cuvelo.usecases.executor;

import io.reactivex.Scheduler;

/**
 * Thread abstraction, used to change the execution context
 * from any thread to any another thread.*/
public interface PostExecutionThread {
    Scheduler getScheduler();
}
