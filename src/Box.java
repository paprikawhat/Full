class Box {
    // ОБЪЯВЛЕНИЕ ПАРАМЕТРОВ И МЕТОДОВ ОБРАЩЕНИЯ С ПАРАМЕТРАМИ
    private double height;
    void h(double n) {height = n;}
    private double width;
    void w(double n) {width = n;}
    private double depth;
    void d(double n) {depth = n;}
    private double weight;
    void wh(double n) {weight = n;}
    private float price;
    void p(float n) {price = n;}
    private boolean isEasy;
    boolean e() {isEasy = (weight <= 10000) && (height+width+depth < 150) && (height < 100 && width < 100 && depth < 100);
        return isEasy;
    }
    void volume() {
        double v = height*width*depth;
        System.out.println("Объём коробки: " + v/1000 + " литров");
    }
    void param() {
        System.out.println("Размеры: " + height + " x " + width + " x " + depth + "\nВес: " + weight/1000 + " кг.");
        if (isEasy) {
            System.out.println("Отправить!");
        } else {
            System.out.println("Сложность с отправлением.");
        }
        System.out.println("Цена отправления: ");
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
        price = 0;
    }
    Box(double h, double w, double d, double wh) { // КОНСТРУКТОР С УКАЗАНИЕМ РАЗМЕРОВ
        height = h;
        width = w;
        depth = d;
        weight = wh;
        isEasy = (wh <= 10000) && (h+w+d < 150) && (h < 100 && w < 100 && d < 100);
    }

}