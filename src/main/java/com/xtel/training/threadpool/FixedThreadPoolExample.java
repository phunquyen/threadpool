package com.xtel.training.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static final int num_of_thread = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(num_of_thread);
        for (int i = 0; i <= 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("Finished all thread");
    }
}
