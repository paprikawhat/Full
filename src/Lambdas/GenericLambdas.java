package src.Lambdas;

interface genFunc<T> {
    boolean func(T v1, T v2);
}

class DayTemperature {
    private final int t;
    DayTemperature(int n) {
        t = n;
    }
    boolean isSame(DayTemperature t2) {
        return t2.t == t;
    }
    boolean less(DayTemperature t2) {
        return t < t2.t;
    }
    boolean more(DayTemperature t2) {
        return t > t2.t;
    }
}

class Counter {
    static <T> int counter(T[] vals, genFunc<T> f, T v) {
        int count = 0;
        for (T val : vals) {
            if (f.func(val, v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DayTemperature[] weekTemps = {new DayTemperature(20), new DayTemperature(15), new DayTemperature(18),
                                      new DayTemperature(19), new DayTemperature(15), new DayTemperature(21),
                                      new DayTemperature(22)};
        Integer[] weekTemps2 = {14, 18, 20, 21, 19, 16, 20};

        int sameCount = Counter.counter(weekTemps, DayTemperature::isSame, new DayTemperature(15));
        int less = Counter.counter(weekTemps, DayTemperature::less, new DayTemperature(40));
        System.out.printf("This week has %d days with temp 15⁰ and %d days with temp less than 40⁰", sameCount, less);
    }
}