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

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;
    private static final String TAG = "JobExecutor";

    //Time to waits before terminating
    private static final int KEEP_ALIVE_TIME = 10;

    //Set the time unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public JobExecutor() {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        ThreadFactory threadFactory = new JobThreadFactory();
        this.threadPoolExecutor =  new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, workQueue, threadFactory);
    }

    @Override
    public void execute( Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "ANDROID ";

        @Override
        public Thread newThread(Runnable runnable) {
            int counter = 0;
            final Thread thread = new Thread(runnable, THREAD_NAME + counter);
            thread.setPriority(Thread.MIN_PRIORITY);

            System.out.println(TAG+" newThread name: "+thread.getName());
            return thread;
        }
    }
}