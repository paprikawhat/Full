package src;

import java.lang.annotation.*;
import java.lang.reflect.*;
// @Retention определяет политику хранения аннотаций
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String str() default "Строка по-умолчанию";
    int val() default 0;
}
@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
// Маркеры аннотации не содержат членов
@Retention(RetentionPolicy.RUNTIME)
@interface Marker {}
// @Target используется перед аннотацией для указания через ({ElementType})
class Meta {
    // Аннотировать метод.
    @MyAnnotation(str = "Пример аннотации", val = 100)
    public static void myMeth(String str, int i) {
        Meta ob = new Meta();
        try {
            // Получение экземпляра Class от объекта ob.
            Class<?> c = ob.getClass();
            // Теперь получить экземпляр Method для MyMeth через запятую с аргументами если они указаны
            Method m = c.getMethod("myMeth", String.class, int.class); // Выбрасывает исключение
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
@What(description = "Class annotation")
@MyAnnotation(str =  "Meta2", val = 99)
class Meta2 {
    @What(description = "Method annotation")
    @MyAnnotation(str = "Testing", val = 100)
    public static void myMeth2() {
        Meta2 ob = new Meta2();
        try {
            // Получение всех аннотаций getAnnotations() возвращает Annotation[]
            Annotation[] annotations = ob.getClass().getAnnotations();
            // Отобразить все аннотации для Meta2;
            System.out.println("Все аннотации для Meta2:");
            for (Annotation a : annotations) {
                System.out.println(a);
            }
            System.out.println();
            // Отобразить все аннотации для myMeth.
            Method m = ob.getClass().getMethod("myMeth");
            annotations = m.getAnnotations();
            System.out.println("Все аннотации метода myMeth:");
            for (Annotation a : annotations) {
                // В Annotation метод toString() переопределен таким образом что он вызывается
                // при выводе ссылки
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }
    public static void main(String[] args) {
        myMeth2();
    }
}
class Meta3 {
    @Marker
    @MyAnnotation()
    public static void myMeth3() {
        Meta3 ob = new Meta3();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth3");
            MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }
    public static void main(String[] args) {
        myMeth3();
    }
}
class  AnnoMark {
    @Marker // Маркерная аннотация
    public static void myMeth4() {
        AnnoMark ob = new AnnoMark();
        try {
            Method m = ob.getClass().getMethod("myMeth4");
            // isAnnotationPresent() возвращает boolean присутствия аннотации по объекту Class
            if(m.isAnnotationPresent(Marker.class)) {
                System.out.println("Marker присутствует");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("Метод не найден");
        }
    }
    public static void main(String[] args) {
        myMeth4();
    }
}