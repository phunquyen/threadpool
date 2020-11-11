package com.xtel.training.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static final int num_of_thread = 2;
    public static final int initial_delay = 1;
    public static final int delay = 3;

    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(num_of_thread);
        for (int i = 0; i <= 5; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.scheduleWithFixedDelay(worker, initial_delay, delay, TimeUnit.SECONDS);
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
