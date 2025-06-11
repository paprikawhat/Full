package src.chapterTwo.Concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarrierAction());
        System.out.println("START");
        new Thread(new CBThread(cyclicBarrier, "A")).start();
        new Thread(new CBThread(cyclicBarrier, "B")).start();
        new Thread(new CBThread(cyclicBarrier, "C")).start();
    }
}
class CBThread implements Runnable{
    String name;
    CyclicBarrier cb;
    CBThread(CyclicBarrier cb, String name) {
        this.name = name;
        this.cb = cb;
    }
    @Override
    public void run() {
        try {
            System.out.println(name);
            cb.await();
        } catch (BrokenBarrierException | InterruptedException e) {
            System.out.println(e.getMessage());;
        }
    }
}
class BarrierAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier was reached");
    }
}
