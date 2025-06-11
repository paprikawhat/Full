package src.chapterTwo.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class DoubleSum extends RecursiveTask<Double> {
    final int threshold = 500;
    double[] data;
    int start, end;
    DoubleSum(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }
    @Override
    protected Double compute() {
        double sum = 0;
        if((end - start) < threshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int mid = (start + end) / 2;
            DoubleSum subS1 = new DoubleSum(data, start, mid);
            DoubleSum subS2 = new DoubleSum(data, mid, end);
            subS1.fork();
            subS2.fork();
            sum = subS1.join() + subS2.join();
        }
        return sum;
    }
}
public class RecursiveTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = ForkJoinPool.commonPool();
        double[] numbs = new double[5000];
        for (int i = 0; i < numbs.length; i++) {
             numbs[i] = (double) ((i % 2) == 0 ? i : -i);
        }
        DoubleSum task = new DoubleSum(numbs, 0, numbs.length);
        double sum = fjp.invoke(task);
        System.out.println("Result: " + sum);
    }
}
