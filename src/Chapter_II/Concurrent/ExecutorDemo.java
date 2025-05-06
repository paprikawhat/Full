package src.Chapter_II.Concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("The beginning");
        es.execute(new MyCDThread(cd1, "A"));
        es.execute(new MyCDThread(cd2, "B"));
        es.execute(new MyCDThread(cd3, "C"));
        es.execute(new MyCDThread(cd4, "D"));
        try {
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        es.shutdown();
        System.out.println("The end");
    }
}
class MyCDThread implements Runnable{
    String name;
    CountDownLatch cd;
    MyCDThread(CountDownLatch cd, String name) {
        this.cd = cd;
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cd.countDown();
        }
    }
}
