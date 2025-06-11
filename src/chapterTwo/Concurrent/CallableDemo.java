package src.chapterTwo.Concurrent;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> sum;
        Future<Double> hypo;
        Future<Integer> fact;
        System.out.println("START");
        sum = es.submit(new Sum(10));
        hypo = es.submit(new Hypo(12, 4));
        fact = es.submit(new Factorial(15));
        try {
            System.out.println(sum.get());
            System.out.println(hypo.get());
            System.out.println(fact.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        es.shutdown();
        System.out.println("END");
    }
}
class Sum implements Callable<Integer> {
    int stop;
    Sum(int v) { stop = v; }
    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 1; i < stop; i++) {
            sum += i ;
        }
        return sum;
    }
}
class Hypo implements Callable<Double> {
    double side1, side2;
    Hypo(double d1, double d2) {
        side1 = d1;
        side2 = d2;
    }
    @Override
    public Double call() throws Exception {
        return Math.sqrt((side1 * side1) + (side2 * side2));
    }
}
class Factorial implements Callable<Integer> {
    int stop;
    Factorial(int v) { stop = v; }
    @Override
    public Integer call() throws Exception {
        int fact = 1;
        for (int i = 2; i < stop; i++) {
            fact *= i;
        }
        return fact;
    }
}