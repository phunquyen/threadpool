package com.xtel.training.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SingleThreadScheduledExecutor {
    public static final int initial_delay = 2;
    public static final int delay = 3;

    public static void main(String[] args) throws InterruptedException{
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
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
