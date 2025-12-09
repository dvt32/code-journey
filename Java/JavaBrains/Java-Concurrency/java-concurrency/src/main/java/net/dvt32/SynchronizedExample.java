package net.dvt32;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable {
    private int value = 0;
    private Lock l = new ReentrantLock();

    public void increment() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }

    public void decrement() {
        value--;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        l.lock();

        while (true) {
            if (l.tryLock()) {
                try {
                    this.increment();
                    System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
                    this.decrement();
                    System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
                } finally {
                    l.unlock();
                }
            } else {
                System.out.println("Couldn't acquire lock!");
            }
        }
    }

    /*
    @Override
    public void run() {
        l.lock();

        try {
            this.increment();
            System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
            this.decrement();
            System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
        } finally {
            l.unlock();
        }
    }
     */

    /*
    @Override
    public void run() {
        synchronized (this) {
            synchronized (this) {
                this.increment();
                System.out.println(Thread.currentThread().getName() + " increments: " + this.getValue());
                this.decrement();
                System.out.println(Thread.currentThread().getName() + " decrements: " + this.getValue());
            }
        }

    }
     */

}

public class SynchronizedExample {
    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(counter, "One").start();
        new Thread(counter, "Two").start();
        new Thread(counter, "Three").start();
        new Thread(counter, "Four").start();

        Counter counter2 = new Counter();
        new Thread(counter2, "Counter 2 Thread").start();
    }
}