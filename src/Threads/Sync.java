package src.Threads;

class Callme {
    void call(String msg) {
        System.out.println("[");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прерван!");
        }
        System.out.println("]");
    }
}
class Caller implements Runnable{
    String msg;
    Callme target;
    Thread t;
    public  Caller(Callme trg, String s) {
        msg = s;
        target = trg;
        t = new Thread(this);
    }
    public void run() {
        target.call(msg);
    }
}
class Sync {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronizd");
        Caller ob3 = new Caller(target, "World");

        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Прерван!");
        }

    }
}