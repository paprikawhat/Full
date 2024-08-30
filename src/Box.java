abstract class Box {
    private double height; // ОБЪЯВЛЕНИЕ ПАРАМЕТРОВ
    private double width;
    private double depth;
    double volume() {
        return height * width * depth;
    }
    Box(Box ob) { // КОНСТРУКТОР ДЛЯ КЛОНИРОВАНИЯ
        height = ob.height;
        width = ob.width;
        depth = ob.depth;
    }
    Box() { // КОНСТРУКТОР ПО-УМОЛЧАНИЮ
        height = -1;
        width = -1;
        depth = -1;
    }
    Box(double h, double w, double d) { // КОНСТРУКТОР С УКАЗАНИЕМ РАЗМЕРОВ
        height = h;
        width = w;
        depth = d;
    }

}
class BoxShipping extends Box { // РАСШИРЯЮЩИЙ КЛАСС
    double weight; // ДОБАВЛЕНИЕ ПАРАМЕТРОВ
    boolean isEasy;
    BoxShipping(BoxShipping ob) { // КОНСТРУКТОР ДЛЯ КЛОНИРОВАНИЯ
        super(ob);
        weight = ob.weight;
        isEasy = ob.isEasy;
    }
    BoxShipping(double h, double w, double d, double m, boolean s) { //КОНСТРУКТО С УКАЗАНИЕМ ВСЕХ ПАРАМЕТРОВ
        super(h, w, d);
        weight = m;
        isEasy = s;
    }
    BoxShipping() { //КОНСТРУКТОР ПО-УМОЛЧАНИЮ
        super();
        weight = -1;
        isEasy = false;
    }
}