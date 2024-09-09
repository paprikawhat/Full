package src.Threads;
/* Класс реализует приостановку и возобновление потока с помощью флаговой переменной flag. */
class newSusThread implements Runnable{
    String name;
    Thread t;
    boolean flag;
    // Конструктор
    newSusThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + name);
        flag = false;
    }
    @Override
    public void run() {
        try {
            for(int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while(flag) { // wait() всегда должен находиться
                        wait();    // внутри цикла проверки условий.
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
    //
    synchronized void mySuspend() {
        flag = true;
    }
    synchronized void myResume() {
        flag = false;
        notify();
    }
}/* ThreadSuspend создает два экземпляра newSusThread, в каждом из которых запускается поток
 ведущий обратный отсчет от 15 до 1. Затем у экземпляров вызываются синхронизированные методы
 mySuspend() и myResume(). Между каждым вызовом стоит задержка в одну секунду.  */
public class ThreadSuspend {
    public static void main(String[] args) {
        newSusThread ob1 = new newSusThread("One");
        newSusThread ob2 = new newSusThread("Two");
        // Запуск потоков.
        ob1.t.start();
        ob2.t.start();
        try {
            Thread.sleep(1000);
            // Приостановка выполнения потока экземпляра ob1
            ob1.mySuspend();
            // Сейчас выполняется только поток объекта ob2
            System.out.println("Приостановка потока One");
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Возобновление потока One");
            Thread.sleep(1000);
            ob2.mySuspend();
            System.out.println("Приостановка потока Two");
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Возобновление потока Two");
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        try {
            System.out.println("Ожидание завершения потоков");
            ob1.t.join(); // join()
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
