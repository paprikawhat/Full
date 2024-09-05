package src.Threads;
/* В классах А и В методы foo() и bar()  приостанавливаются перед попыткой вызвать метод
 из другого класса. Основной класс создает экземпляры А и В и вызывает собственный метод
 deadLockStart(), чтобы запустить второй поток, который настраивает условия для взаимоблокировки.
 методы foo() и bar() используют sleep() как способ вызвать состояние взаимоблокировки. */
public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();
    Thread t;

    DeadLock() {
        Thread.currentThread().setName("MainTread");
        t = new Thread(this, "RacingTread");
    }
    void deadLockStart () {
        t.start();
        a.foo(b);
        System.out.println("Назад в главный поток");
    }
    public void run() {
        b.bar(a);
        System.out.println("Назад в дочерний поток");
    }
    public static void main(String[] args) {
        DeadLock dL = new DeadLock();
        dL.deadLockStart();
    }
}
class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в A.foo");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
          System.out.println("A прерван");
        }
        System.out.println(name + " пытается вызвать b.last");
        b.last();
    }
    synchronized void last() {
        System.out.println("Внутри A.last()");
    }
}
class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в B.bar");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("B прерван");
        }
        System.out.println( name + " пытается вызвать A.last");
        a.last();
    }
    synchronized void last() {
        System.out.println("Внутри B.last()");
    }
}