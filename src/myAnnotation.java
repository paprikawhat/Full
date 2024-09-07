package src;

import java.lang.annotation.*;
import java.lang.reflect.*;
// Объявление аннотации типа.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String str();
    int val();
}
class Meta {
    // Аннотировать метод.
    @MyAnnotation(str = "Пример аннотации", val = 100)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();
        try {
            // Получение экземпляра класса Class.
            Class<?> c = ob.getClass();
            // Теперь получить экземпляр Method.
            Method m = c.getMethod("myMeth", String.class, int.class);
            // Далее получить аннотацию для этого класса.
            MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
            // Вывод значений в консоль.
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Метод не найден");
        }
    }
    public static void main(String[] args) {
        myMeth("Test", 200);
    }
}
/*
@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
@What(description = "Аннотация класса")
@MyAnnotation(str =  "Meta2", val = 99)
class Meta2 {
    @What(description = "Аннотация метода")
    @MyAnnotation(str = "Testing", val = 100)
    public static void myMeth() {
        Meta2 ob = new Meta2();
        try {
            Annotation[] annos = ob.getClass().getAnnotations()
            // Отобразить все аннотации для Meta2;
            System.out.println("Все аннотации для Meta2:");
            for (Annotation a : annos) {
                System.out.println(a);
            }
            System.out.println();
            // Отобразить все аннотации для myMeth.
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("Все аннотации метода myMeth:");
            for (Annotation a : annos) {
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }
    public static void main(String[] args) {
        myMeth();
    }
}
*/