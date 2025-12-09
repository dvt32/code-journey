package net.dvt32;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrimeNumberWithThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(1);
        Runnable reporterRunnable = () -> {
            System.out.println("running report");
            System.out.println("Active threads: " + executorService.getActiveCount());
            System.out.println("Completed threads: " + executorService.getCompletedTaskCount());
        };
        scheduledService.scheduleAtFixedRate(reporterRunnable, 1, 5, TimeUnit.SECONDS);

        while (true) {
            Scanner sc = new Scanner(System.in);

            System.out.print("\n I can tell you the nth prime number. Enter n: ");
            int n = sc.nextInt();
            if (n == 0) break;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n Result:");
                    System.out.println("\n Value of " + n + "th prime: " + number);
                }
            };

            executorService.execute(r);
        }
    }

}