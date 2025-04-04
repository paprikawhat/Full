package src.Chapter_II;

import java.util.*;

class MyTimerTask extends TimerTask {
    public void run() {
        System.out.println("Execution");
    }
}
public class TimerTaskClass {
    public static void main(String[] args) {
        MyTimerTask mt = new MyTimerTask();
        Timer myTimer = new Timer();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        myTimer.schedule(mt, 1000L, 1500L);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        myTimer.cancel();
        System.out.println(calendar.getTime());
    }
}
