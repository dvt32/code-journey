package net.dvt32;

import java.util.concurrent.RecursiveTask;

public class CalculatePrimeTask extends RecursiveTask<Integer> {
    int[] array;
    int start;
    int end;

    public CalculatePrimeTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (start == end) {
            System.out.println(array[start] + ":" + PrimeNumberUtil.calculatePrime(array[start]));
            return PrimeNumberUtil.calculatePrime(array[start]);
        }
        if (end - start == 1) {
            System.out.println(array[start] + ":" + PrimeNumberUtil.calculatePrime(array[start]));
            System.out.println(array[end] + ":" + PrimeNumberUtil.calculatePrime(array[end]));
            return PrimeNumberUtil.calculatePrime(array[start]) + PrimeNumberUtil.calculatePrime(array[end]);
        }
        int mid = (start + end) / 2;
        CalculatePrimeTask subTask1 = new CalculatePrimeTask(array, start, mid);
        CalculatePrimeTask subTask2 = new CalculatePrimeTask(array, mid + 1, end);
        invokeAll(subTask1, subTask2);
        return subTask1.join() + subTask2.join();
    }
}
