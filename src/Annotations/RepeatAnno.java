package src.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)  // Необходимая аннотация для повторения
@interface MyAnno { // Сам повторяемый метод
    String str() default "Test";
    int value() default  9000;
}
// Это контейнерная аннотация
@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos {
    MyAnno[] value();
}
public class RepeatAnno {
    @MyAnno(str = "first anno", value = -1)
    @MyAnno(str = "second anno", value = 1000)
    public static void myRepeatMeth() {
        RepeatAnno ob = new RepeatAnno();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myRepeatMeth");
            Annotation anno = m.getAnnotation(MyRepeatedAnnos.class);
            System.out.println(anno);
        } catch(NoSuchMethodException e) {
            System.out.println("NoSuchMethod");
        }
    }
    public static void main(String[] args) {
        myRepeatMeth();
    }
}
class RepeatAnno2 {
    @MyAnno(str = "first anno", value = -1)
    @MyAnno(str = "second anno", value = 1000)
    public static void myRepeatMeth2() {
        RepeatAnno2 ob = new RepeatAnno2();
        try {
            Method m = ob.getClass().getMethod("myRepeatMeth");
            Annotation[] anno = m.getAnnotationsByType(MyRepeatedAnnos.class);
            for(Annotation a : anno) {
                System.out.println(a);
            }
        } catch(NoSuchMethodException e) {
            System.out.println("NoSuchMethod");
        }
    }
    public static void main(String[] args) {
        myRepeatMeth2();
    }
}
