package src.Threads;
  //Класс очереди синхронизации.
class Q {
    int n;
    boolean valSet = false; // Переменная определяющая возможность работы с очередью.
    synchronized int get() {
        while (!valSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Перехвачено исключение InterruptedException.");
            }
        }
        System.out.println("Получено: " + n);
        valSet = false;
        notify();
        return n;
    }
    synchronized  void put(int n) {
        while(!valSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Перехвачено исключение InterruptedException.");
            }
        this.n = n;
        valSet = true;
        System.out.println("Отправлено: " +  n);
        notify();
    }
}
  // Потоковый объект создающий записи в очереди(Q).
class Producer implements Runnable{
    Q q;
    Thread t;
    Producer(Q q) {
        this.q = q;
        t = new Thread(this, "Производитель.");
    }
    @Override
    public void run() {
        int i = 0;
        do {
            q.put(i++);
        } while (true);
    }
}
  // Потоковый объект потребляющий записи в очереди(Q).
class Consumer implements Runnable {
    Q q;
    Thread t;
  // Конструктор в который передается объект очереди.
    Consumer(Q q) {
        this.q = q;
        t =  new Thread(this, "Потребитель.");
    }
    @Override
    public void run() {
        do {
            q.get();
        } while (true);
    }
}
  // Создатель объектов
class PC {
    public static void main(String[] args) {
        Q q = new Q();
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);
      // Запуск потоков.
        p.t.start();
        c.t.start();
        System.out.println("Нажмите <Ctrl-C>, чтобы остановить программу.");
    }
}
}