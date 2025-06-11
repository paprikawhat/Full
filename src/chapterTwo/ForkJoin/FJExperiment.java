package src.chapterTwo.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int threshold, start, end;
    double[] data;
    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        threshold = t;
    }
    @Override
    protected void compute() {
        if((end - start) < threshold) {
            for (int i = start; i < end; i++) {
                if((data[i] / 2) == 0) {
                    data[i] =Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int mid = (end + start) / 2;
            invokeAll(new Transform(data, start, mid, threshold),
                      new Transform(data, mid, end, threshold));
        }
    }
}
public class FJExperiment {
    public static void main(String[] args) {
        int threshold, pLVL;
        if(args.length != 2) {
            System.out.println("To use: FJExperiment parallel-level threshold");
            return;
        }
        pLVL = Integer.parseInt(args[0]);
        threshold = Integer.parseInt(args[1]);
        long beginT, endT;
        try (ForkJoinPool fjp = new ForkJoinPool(pLVL)) {
            double[] numbs = new double[10_000_000];
            for (int i = 0; i < numbs.length; i++) {
                numbs[i] = (double) i;
            }
            Transform task = new Transform(numbs, 0, numbs.length, threshold);
            beginT = System.nanoTime();
            fjp.invoke(task);
        }
        endT = System.nanoTime();
        System.out.println("Parallelism level: " + pLVL);
        System.out.println("Threshold is: " + threshold);
        System.out.println("The amount of execution time: " + (endT - beginT));
    }
}
