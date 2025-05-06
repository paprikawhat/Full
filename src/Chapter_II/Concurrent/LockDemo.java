package src.Chapter_II.Concurrent;

import src.Chapter_I.Threads.CurrentThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock();
        new Thread(new LockThread(rl, "A")).start();
        new Thread(new LockThread(rl, "B")).start();
    }
}
class Shared {
    static int count = 0;
}
class LockThread implements Runnable{
    String name;
    ReentrantLock lock;
    LockThread(ReentrantLock lock, String name) {
        this.lock = lock;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Start: " + name);
        try {
            System.out.println(name + " awits for lock");
            lock.lock();
            System.out.println(name + " is blocking the count");
            Shared.count++;
            System.out.println(name + ": " + Shared.count);
            System.out.println(name + " is waiting");
            Thread.sleep(1500);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(name + " unlocks the count");
            lock.unlock();
        }
    }
}
