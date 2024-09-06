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
        myMeth("Test", 200);;
    }
}