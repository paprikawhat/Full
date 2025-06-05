package src.Chapter_II.Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(new AtomThread("B")).start();

        new Thread(new AtomThread("C")).start();
    }
}
class SharedAtomic {
    static AtomicInteger ai = new AtomicInteger(0);
}
class AtomThread implements Runnable {
    String name;
    AtomThread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " started");
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " got: " + SharedAtomic.ai.getAndSet(i));
        }
    }
}
