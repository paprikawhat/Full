package src.chapterTwo.Concurrent;


import java.util.concurrent.Phaser;

class MyPhaser extends Phaser {
    int numPhases;
    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Stage " + phase + " is done");
        return phase == numPhases || registeredParties == 0;
    }
}
public class MyPhaserDemo {
    public static void main(String[] args) {
        MyPhaser mp = new MyPhaser(1, 4);
        System.out.println("START");
        new Thread(new MyPThread(mp, "A")).start();
        new Thread(new MyPThread(mp, "B")).start();
        new Thread(new MyPThread(mp, "C")).start();
        while (!mp.isTerminated()) {
            mp.arriveAndAwaitAdvance();
        }
        System.out.println("Phaser accomplished");
    }
}
class MyPThread implements Runnable {
    Phaser ph;
    String name;
    MyPThread(Phaser ph, String name) {
        this.ph = ph;
        this.name = name;
        ph.register();
    }
    @Override
    public void run() {
        while(!ph.isTerminated()) {
            System.out.println("Thread " + name + " starts phase " + ph.getPhase());
            ph.arriveAndAwaitAdvance();
        }
    }
}