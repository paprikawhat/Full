package src.chapterTwo.Concurrent;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;
        System.out.println("Beginning!");
        new Thread(new PhaserThread(phaser, "a")).start();
        new Thread(new PhaserThread(phaser, "b")).start();
        new Thread(new PhaserThread(phaser, "c")).start();

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " complite");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " complite");

        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " complite");

        phaser.arriveAndDeregister();
        if(phaser.isTerminated()) {
            System.out.println("Object Phaser accomplished");
        }

    }
}
class PhaserThread implements Runnable{
    Phaser ph;
    String name;
    PhaserThread(Phaser ph, String name) {
        this.name = name;
        this.ph = ph;
        ph.register();
    }
    @Override
    public void run() {
        System.out.println("Thread " + name + " startrd first phase");
        ph.arriveAndAwaitAdvance();
        // Паузы для вывода по порядку, но не требуются для корректной работы
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + name + " started second phase");
        ph.arriveAndAwaitAdvance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread " + name + " started third phase");
        ph.arriveAndDeregister();
    }
}