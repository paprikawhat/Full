package src.chapterTwo.JavaUtil;

import java.util.Optional;
// помогает в обходе исключений связанных с null при обращении
public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty(); // Null значение для ссылки
        Optional<String> hasVal = Optional.of("This is just an example!");
        if(!noVal.isPresent()) System.out.println("String_1 has no value");
        if(hasVal.isPresent()) System.out.println("String_1: " + hasVal.get());
        String str = noVal.orElse("Other String!");
        System.out.println(str);
    }
}
