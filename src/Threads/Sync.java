package src.Threads;
/* Как только поток входит в какой-либо синхронизированный
  метод в экземпляре, никакой другой поток не может входить в любой
  другой синхронизированный метод в том же экземпляре. */
class Call {
    // Синхронизированный метод может быть вызван лишь одним потоком за раз
    /* <synchronized> */void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прерван!");
        }
        System.out.println("]");
    }
}
// Класс реализующий многопоточность.class Caller implements Runnable{
class Caller implements Runnable{
    Call target;
    String msg;
    Thread t;
    public  Caller(Call trg, String s) {
        target = trg;
        msg = s;
        t = new Thread(this);
    }
    public void run() {
        {
            // Синхронизация методов объекта.
            synchronized(target) { // Объект.
                target.call(msg); // Методы.
            }
        }
    }
}
class Sync {
    public static void main(String[] args) {
        Call target = new Call();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
        Caller ob3 = new Caller(target, "World");
        // Запуск потоков.
        ob1.t.start();
        ob2.t.start();
        ob3.t.start();
        // Ожидание окончаний работы потоков
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
      // Ошибка прерывания потока выполнения.
        } catch (InterruptedException e) {
            System.out.println("Прерван!");
        }

    }
}