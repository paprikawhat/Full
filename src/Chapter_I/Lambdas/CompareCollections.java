package src.Chapter_I.Lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

interface  myFunc {
    MyClass func(int n);
}
class MyClass {
    private final int val;
    MyClass(int v) {
        val = v;
    }
    MyClass() {
        val = 0;
    }
    int getVal() {
        return val;
    }
}
class MethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }
    public static void main(String[] args) {
        Random random = new Random();
        myFunc myClassCons = MyClass::new;
        ArrayList<MyClass> arrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            arrayList.add(myClassCons.func(random.nextInt(1, 1000)));
        }
        for(MyClass mc : arrayList) {
            System.out.printf("[ %d ]", mc.getVal());
        }
        System.out.println();
        MyClass maxValObj = Collections.max(arrayList, MethodRef::compareMC);
        System.out.printf("Max value of array list is %d.", maxValObj.getVal());
    }
}

interface myGenericFunc<R ,T> {
    R func(T n);
}
class MyGenClass<T> {
    private final T val;
    MyGenClass(T v) {
        val = v;
    }
    MyGenClass() {
        val = null;
    }
    T getVal() {
        return val;
    }

}
class GenRefConstructor {
    static <R, T> R myFactory(myGenericFunc<R,T> cons, T v) {
        return cons.func(v);
    }
    public static void main(String[] args) {
        myGenericFunc<MyGenClass<Double>, Double> constructor = MyGenClass<Double>::new;
        MyGenClass<Double> cN1 = myFactory(constructor, 100.0);
        myGenericFunc<MyClass, Integer> constructor2 = MyClass::new;
        MyClass cN2 = myFactory(constructor2, 100);
        //Объявление записи.
        record Employee(String name, int idNum){}
        //Создание записи.
        Employee employee = new Employee("John", 5554);
        System.out.printf("Employee %s has %d number.",employee.name(), employee.idNum());
    }
}
/*
Предопределённые функциональные интерфейсы Java:
UnaryOperator<T> Применяет унарную операцию к объекту типа Т
                 и возвращает результат тоже типа Т. Его метод
                 называется apply()
BinaryOperator<T> Применяет операцию к двум объектам типа Т
                  и возвращает результат тоже типа Т. Его метод
                  называется apply()
Consumer<T> Применяет операцию к объекту типа т. Его метод
            называется accept()
Supplier<T> Возвращает объект типа Т. Его метод называется get()
Function<T, R> Применяет операцию к объекту типа Т и возвращает
               в качестве результата объект типа R. Его метод
               называется apply()
Predicate<T> Выясняет, удовлетворяет ли объект типа Т
             определенному ограничению. Возвращает булевское
             значение, указывающее на результат проверки. Его
             метод называется test()
*/