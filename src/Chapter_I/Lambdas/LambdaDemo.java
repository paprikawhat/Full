package src.Chapter_I.Lambdas;

interface NumTest {
    boolean test(int n);
}
interface SomeFunction<T> {
    T func(T t);
}

class DemoTest {
    public static void main(String[] args) {
        NumTest isEven = (n) -> (n%2) == 0;
        NumTest isNegative = (n) -> n < 0;
        if(isEven.test(5)) System.out.println("Yes");
        if(isNegative.test(-48)) System.out.println("Yes");
    }
}

class DemoSomeFunction {
    public static void main(String[] args) {
        SomeFunction<String> reverseString = (str) -> {
            StringBuilder result = new StringBuilder();
            for(int i = str.length() - 1; i >= 0; i--) result.append(str.charAt(i));
            return result.toString();
        };
        System.out.println(reverseString.func("Что у вас тут происходит!?"));
    }
}

interface StrFunction {
    String func(String n);
}
class StringStaticMethods {
    static String strReverse(String str) {
        StringBuilder result = new StringBuilder();
        int i;
        for(i = str.length() - 1; i >= 0; i--) result.append(str.charAt(i));
        return result.toString();
    }
    static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
class DemoReferences {
    static String strOp(StrFunction strFunction, String str) {
        return strFunction.func(str);
    }
    public static void main(String[] args) {
        String one = "This is normal string and reverse string";
        String two;
        String upper;
// Передача ссылки на статический метод класса в качестве аргумента
        two = strOp(StringStaticMethods::strReverse, one);
        System.out.println(two);
        upper = strOp(StringStaticMethods::toUpperCase, one);
        System.out.println(upper);
    }
}
