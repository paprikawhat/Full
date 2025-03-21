package src.Chapter_II;



class NewThread extends Thread {
    boolean flag = false;
    NewThread(String name, ThreadGroup group) {
        super(group, name);
        System.out.println(STR."New thread: \{this}");
    }
    synchronized public void mySuspend() {
        flag = true;
    }
    synchronized public void myResume(){
        flag = false;
        notifyAll();
    }
    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(STR."\{getName()}:\{i}");
                Thread.sleep(1000);
                synchronized (this) {
                    while (flag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(STR."Exception in \{getName()}");;
        }
        System.out.println(STR."\{getName()} ended work.");
    }
}

public class Creator {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");
        NewThread newThread_1 = new NewThread("One", groupA);
        NewThread newThread_2 = new NewThread("Two", groupA);
        NewThread newThread_3 = new NewThread("Three", groupB);
        NewThread newThread_4 = new NewThread("Four", groupB);

        newThread_1.start();
        newThread_2.start();
        newThread_3.start();
        newThread_4.start();

        System.out.println("\nListing: ");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Suspending groupA");
        Thread[] threadsA = new Thread[groupA.activeCount()];
        groupA.enumerate(threadsA);
        for (Thread thread : threadsA) {
            ((NewThread) thread).mySuspend();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
        }
        System.out.println("Resume groupA");
        for (Thread thread : threadsA) {
            ((NewThread) thread).myResume();
        }
        try {
            System.out.println("Waiting for all to join");
            newThread_1.join();
            newThread_2.join();
            newThread_3.join();
            newThread_4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("END");
        Module myModule = Creator.class.getModule();
        System.out.println(STR."Module: \{myModule.getName()}");
        System.out.println("Packages:");
        for (String pkg : myModule.getPackages()) {
            System.out.println(STR."\{pkg} ");
        }
    }
}
