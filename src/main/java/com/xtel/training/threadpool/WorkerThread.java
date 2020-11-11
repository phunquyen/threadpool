package com.xtel.training.threadpool;

public class WorkerThread implements Runnable{
    private String task;
    public WorkerThread(String s) {
        this.task = s;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " Starting. Task = " + task);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " Finished.");
    }

    private static void processCommand(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
