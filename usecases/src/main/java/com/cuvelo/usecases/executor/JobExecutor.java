package com.cuvelo.usecases.executor;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class JobExecutor implements ThreadExecutor{

    private final int INITIAL_POOL_SIZE = 3;
    private final int MAX_POOL_SIZE = 5;

    //Time to waits before terminating
    private final int KEEP_ALIVE_TIME = 10;

    //Set the time unit to seconds
    private final  TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final BlockingQueue<Runnable> workQueue;

    private final ThreadPoolExecutor threadPoolExecutor;

    private final ThreadFactory threadFactory;

    @Inject
    public JobExecutor() {
        this.workQueue =  new LinkedBlockingDeque<>();
        this.threadFactory = new JobThreadFactory();
        this.threadPoolExecutor =  new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, this.workQueue, this.threadFactory);
    }

    @Override
    public void execute(Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private class JobThreadFactory implements ThreadFactory {
        private final String THREAD_NAME = "ANDROID";
        private int counter = 0;

        @Override
        public Thread newThread(Runnable runnable) {
            final Thread thread = new Thread(runnable, THREAD_NAME + counter);
            thread.setPriority(Thread.MIN_PRIORITY);
            return thread;
        }
    }


}
