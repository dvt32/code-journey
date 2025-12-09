package net.dvt32;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed from Runnable!");
            }
        };

        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Printed from Callable!");
                Thread.sleep(2000);
                return "Value from Callable";
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> ret = executor.submit(c);
        System.out.println("Executing things in the main thread");
        System.out.println("Executing more things in the main thread");
        String retStr = null;
        try {
            retStr = ret.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(retStr);
    }
}