package src.chapterTwo.JavaUtil;

import java.util.Timer;
import java.util.TimerTask;

class MyTimerTask extends TimerTask {
    public void run() {
        System.out.println("Executing the program!");
    }
}
public class TimerTaskClass {
    public static void main(String[] args) {
        MyTimerTask myTask = new MyTimerTask();
        Timer timer = new Timer();
        timer.schedule(myTask, 3000, 1000);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        timer.cancel();
    }
}
