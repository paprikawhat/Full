package src.Threads;
/* В создаваемом экземпляре класса Q синхронизированные методы не могут быть вызваны
 одновременно из двух разных объектов */
class Q {
    int n;
    boolean valueSet = false; // Переменная для проверки условия ожидания.

    synchronized void put(int n) {
        while (valueSet) {  // Оператор wait() всегда должен находиться
            try {           // внутри цикла проверяющего условие ожидания потока.
                wait();
            } catch (InterruptedException e) {
                System.out.println("Перехвачено исключение IE.");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Помещено: " + n);
        notify();
    }
    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Перехвачено исключение IE.");
            }
        }
            System.out.println("Извлечено: " + n);
            valueSet = false;
            notify();
            return n;
    }
}
// Объект для реализации потока производителя.
class Producer implements Runnable{
    Q q = new Q();
    Thread t;
    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Producer");
    }
    @Override //
    public void run() {
        int i = 0;
        while(true) { // Поток бесконечного выполнения.
            q.put(i++);
        }
    }
}
// Объект для реализации потока потребителя.
class  Consumer implements Runnable{
    Q q;
    Thread t;
    Consumer(Q q) {
        this.q = q;
        t = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        while(true) { // Поток бесконечного выполнения.
            q.get();
        }
    }
}
public class Queue {
    public static void main(String[] args) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
        p.t.start();
        c.t.start();
        System.out.println("Ctrl-F2 to stop.");
    }
}