public class Box {
    double height; // ОБЪЯВЛЕНИЕ ПАРАМЕТРОВ
    double width;
    double depth;
    double weight; // ДОБАВЛЕНИЕ ПАРАМЕТРОВ
    boolean isEasy;
    float price;
    double volume() { // МЕТОД ВЫЧИСЛЕНИЯ ОБЪЁМА
        return height * width * depth;
    }
    Box(Box ob) { // КОНСТРУКТОР ДЛЯ КЛОНИРОВАНИЯ
        height = ob.height;
        width = ob.width;
        depth = ob.depth;
        weight = ob.weight;
        price = ob.price;
        isEasy = ob.isEasy;
    }
    Box() { // КОНСТРУКТОР ПО-УМОЛЧАНИЮ
        height = -1;
        width = -1;
        depth = -1;
        weight = -1;
        isEasy = true;
    }
    Box(double h, double w, double d, double wh) { // КОНСТРУКТОР С УКАЗАНИЕМ РАЗМЕРОВ
        height = h;
        width = w;
        depth = d;
        weight = wh;
        isEasy = weight <= 1000 || h + w + d > 150 || h > 150 || w > 150  || d > 150;
    }

}