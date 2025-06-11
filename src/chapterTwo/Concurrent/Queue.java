package src.chapterTwo.Concurrent;

import java.util.concurrent.Semaphore;

class Queue {
    int n;
    static Semaphore semProducer = new Semaphore(1);
    static Semaphore semConsumer = new Semaphore(0);
    void put(int n) {
        try {
            semProducer.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.n = n;
        System.out.println("put " + n);
        semConsumer.release();
    }
    void get() {
        try {
            semConsumer.acquire();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("got " + n);
        semProducer.release();
    }
}
class Producer implements  Runnable {
    Queue q;
    Producer(Queue q) {
        this.q = q;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.put(i);
        }
    }
}
class Consumer implements Runnable {
    Queue q;
    Consumer(Queue q) {
        this.q = q;
    }
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            q.get();
        }
    }
}
class QDemo {
    public static void main(String[] args) {
        Queue q = new Queue();
        new Thread(new Producer(q), "Producer").start();
        new Thread(new Consumer(q), "Consumer").start();
    }
}