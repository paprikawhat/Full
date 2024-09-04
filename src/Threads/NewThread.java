package Threads;

class NewThread implements Runnable {
    Thread t;
    NewThread() {
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
        NewThread nt = new NewThread();
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