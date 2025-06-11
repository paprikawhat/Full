package src.chapterTwo.Concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Beginning");
        new Thread(new MyThread(cdl)).start();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End");
    }
}
class MyThread implements Runnable {
    CountDownLatch latch;
    MyThread(CountDownLatch cdl) {
        latch = cdl;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(i);
            latch.countDown();
        }
    }
}