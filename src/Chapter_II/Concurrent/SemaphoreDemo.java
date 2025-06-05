package src.Chapter_II.Concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncThread(semaphore, "A")).start();
        new Thread(new DecThread(semaphore, "B")).start();
    }
}

class SharedResource {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;
    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " waiting for permission");
            sem.acquire();
            System.out.println(name + " got permission");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                SharedResource.count++;
                System.out.println(name + ": " + SharedResource.count);
                // Переключить контекст по возможности
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " releasred the resource");
        sem.release();
    }
}

class DecThread implements Runnable{
    String name;
    Semaphore sem;
    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " waiting for permission");
            sem.acquire();
            System.out.println(name + " got permission");
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                SharedResource.count--;
                System.out.println(name + ": " + SharedResource.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " released the resource");
        sem.release();
    }
}