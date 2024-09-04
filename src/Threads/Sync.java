package src.Threads;
  // Класс реализующий многопоточность.
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
          target.call(msg);
      }
  }
  /* Как только поток входит в какой-либо синхронизированный
    метод в экземпляре, никакой другой поток не может входить в любой
    другой синхронизированный метод в том же экземпляре. */

class Call {
  // Метод может быть вызван лишь одним потоком за раз
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Прерван!");
        }
        System.out.println("]");
    }
}
class Sync {
    public static void main(String[] args) {
        Call target = new Call();
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "Synchronized");
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