package src.Threads;

class NewThreads implements Runnable{
    String name ; // имя: потока
    Thread t ;
    NewThreads(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
    }
// Это точка входа для потока
    @Override
    public void run( ) {
        try{
            for (int i = 5; i > 0 ;i-- ){
                System.out.println(name  + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен.");
    }
}
class DemoJoin {
    public static void main(String [] args ) {
        NewThreads nt1 = new NewThreads ( "One " ) ;
        NewThreads nt2 = new NewThreads( "Two ");
        NewThreads nt3 = new NewThreads("Three ");
    // Запустить потоки
        nt1.t.start() ;
        nt2.t.start() ;
        nt3.t.start() ;
        System.out.println("Поток One работает: " + nt1.t.isAlive()) ;
        System.out.println("Поток Two работает: " + nt2.t.isAlive()) ;
        System.out.println("Поток Three работает: " + nt3.t.isAlive()) ;
        try {
    // Ожидать окончания остальных потоков.
    // join ожидает завершения потока на котором он вызван.
        nt1.t.join();
        nt2.t.join();
        nt3.t.join();
        System.out.println("Поток One: " + nt1.t.isAlive());
        System.out.println("Поток Two: " + nt2.t.isAlive());
        System.out.println("Поток Three: " + nt3.t.isAlive());
        } catch ( InterruptedException e) {
            System.out.println("Главный поток прерван!");
        }
        System.out.println("Завершение главного потока.");
    }
}
