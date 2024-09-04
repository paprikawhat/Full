package Threads;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Текущий поток: " + t);
        t.setName("Отсчет до нуля.");
        System.out.println("Новое имя потока: " + t.getName());
        try {
            for (int n = 5; n >= 0; n--) {
                Thread.sleep(1000);
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("Выполнение потока прервано!");
        }
    }
}
