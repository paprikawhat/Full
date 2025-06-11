package src.chapterOne.Lambdas;

interface genFunc<T> {
    boolean func(T v1, T v2);
}
interface  genericFunc<T> {
    int func(T[] values, T v);
}
class EmptyArray extends Exception {
    EmptyArray() {
        super("Empty array!");
    }
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
    static <T> int counter(T[] vals, genFunc<T> f, T v) throws EmptyArray {
        int count = 0;
        if (vals.length == 0) throw new EmptyArray();
        for (T val : vals) {
            if (f.func(val, v)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws EmptyArray {
        DayTemperature[] weekTemps = {new DayTemperature(20), new DayTemperature(15), new DayTemperature(18),
                                      new DayTemperature(19), new DayTemperature(15), new DayTemperature(21),
                                      new DayTemperature(22)};
        DayTemperature[] weekTempNull = new DayTemperature[0];

        //int nullArray = Counter.counter(weekTempNull, DayTemperature::isSame, new DayTemperature(22));

        int sameCount = Counter.counter(weekTemps, DayTemperature::isSame, new DayTemperature(15));
        int less = Counter.counter(weekTemps, DayTemperature::less, new DayTemperature(40));
        System.out.printf("This week has %d days with temp 15⁰ and %d days with temp less than 40⁰", sameCount, less);
    }
}

class MyArrayOps {
    static <T> int countMatching(T[] values, T v) {
        int count = 0;
        for (T value : values) {
            if (value == v) count++;
        }
        return count;
    }
}
class GenericMethodReference {
    static <T> int GenOp(genericFunc<T> f, T[] values, T v) {
        return  f.func(values, v);
    }
    public static void main(String[] args) {
        Integer[] num = {12, 15, 64, 24, 4, 24, 46, 11, 48, 65, 52, 15};
        String[] str = {"One", "Two", "Three", "One", "Four", "Three", "One"};
        int numCount = GenOp(MyArrayOps::countMatching, num, 15);
        int strCount = GenOp(MyArrayOps::countMatching, str, "One");
        System.out.printf("There is %d 15's in num." +
                " \nThere is %d \"One\"'s in str.", numCount, strCount);
    }
}