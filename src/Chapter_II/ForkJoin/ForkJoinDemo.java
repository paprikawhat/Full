package src.Chapter_II.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class SqrtTransform extends RecursiveAction {
    final int threshold = 1000;
    double[] data;
    int start, end;
    SqrtTransform(double[] d, int s, int e) {
        data = d;
        start = s;
        end = e;
    }
    @Override
    protected void compute() {
        if((end - start) < threshold) {
            for( int i = start; i < end; i++) {
                data[i] = Math.sqrt(i);
            }
        } else {
            int mid = (start + end) / 2;
            invokeAll(new SqrtTransform(data, start, mid),
                      new SqrtTransform(data, mid, end));
        }
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        double[] numbs = new double[10000];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = (double) i;
        }
        System.out.println("Some of source sequence: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(numbs[i] + " ");
        }
        System.out.println("\n");
        SqrtTransform task = new SqrtTransform(numbs, 0, numbs.length);
        fjp.invoke(task);
        System.out.println("Some of modified sequence: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.4f, ", numbs[i]);
        }
    }
}
