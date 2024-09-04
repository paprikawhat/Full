package src.Threads;

class NewThreadRun implements Runnable {
    Thread t;
    NewThreadRun() {
        t = new Thread(this, "Поток 1");
        System.out.println("Дочерний поток: " + t);
    }
    @Override
    // Точка входа для второго потока
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
                Thread.sleep(500);
            }
        } catch(InterruptedException e) {
            System.out.println("Дочерни поток прерван!");
        }
        System.out.println("Дочерний поток завершен.");
    }
}
class ThreadDemo {
    public static void main(String[] args) {
        NewThreadRun nt = new NewThreadRun();
        nt.t.start();
        try {
            for(int i = 5; i > 0; i--) {
                System.out.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
                System.out.println("Главный поток прерван!");
        }
        System.out.println("Завершение главного потока.");
    }
}