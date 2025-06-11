package src.chapterTwo.Concurrent;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new MakeString(ex)).start();
        new Thread(new UseString(ex)).start();
    }
}
class MakeString implements Runnable{
    String str;
    Exchanger<String> ex;
    MakeString(Exchanger<String> c) {
        ex = c;
        str = "";
    }
    @Override
    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                str += ch++;
            }
            try {
                str = ex.exchange(str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class UseString implements Runnable{
    Exchanger<String> ex;
    String str;
    UseString(Exchanger<String> c) {
        ex = c;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                str = ex.exchange("");
                System.out.println("Got: " + str);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}