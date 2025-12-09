package net.dvt32;

// Accept in input array of numbers
// Calculate the n'th prime (where n is value of i in that array arr[i])
// Add all the nth primes

import java.util.concurrent.ForkJoinPool;

public class PrimeNumberWithForkJoin {

    public void runForkJoinExample() {
        int[] inputNumbers = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CalculatePrimeTask calculatePrimeTask = new CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1);
        Integer result = forkJoinPool.invoke(calculatePrimeTask);
        System.out.println("The sum of primes is: " + result);
    }

    public static void main(String[] args) {
        new PrimeNumberWithForkJoin().runForkJoinExample();
    }
}
