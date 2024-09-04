package src.Box;

class Box {
    // ОБЪЯВЛЕНИЕ ПАРАМЕТРОВ И МЕТОДОВ
    String name;
    private double height;
    void setHeight(double n) {height = n;}
    private double width;
    void setWidth(double n) {width = n;}
    private double depth;
    void setDepth(double n) {depth = n;}
    private double weight;
    void setWeight(double n) {weight = n;}
    private float price;
    void setPrice(float n) {price = n;}
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
    Box(Box ob) {// КОНСТРУКТОР ДЛЯ КЛОНИРОВАНИЯ
        name = ob.name;
        height = ob.height;
        width = ob.width;
        depth = ob.depth;
        weight = ob.weight;
        price = ob.price;
        isEasy = ob.isEasy;
    }
    Box() { // КОНСТРУКТОР ПО-УМОЛЧАНИЮ
        name = "Пустое место.";
        height = -1;
        width = -1;
        depth = -1;
        weight = -1;
        price = 0;
    }
    Box(String n, double h, double w, double d, double wh) { // КОНСТРУКТОР С УКАЗАНИЕМ РАЗМЕРОВ
        name = n;
        height = h;
        width = w;
        depth = d;
        weight = wh;
    }

}
class InBox {
    int[] stack;
    int tos;
    InBox(int size) { //ИНИЦИАЛИЗАЦИЯ МАССИВА
        stack = new int[size];
        tos = -1;
    }
    void push (int num) {
        if (tos == stack.length - 1) {
            int[] temp = new int[stack.length*2];
            for (int i = 0; i < num; i++) {
                temp[i] = stack[i];
                stack = temp;
            }
        } else stack[++tos] = num;
    }
    int pop() {
        if (tos <=0) {
            System.out.println("Коробка пуста.");
            return 0;
        } else {
            return stack[tos--];
        }
    }
}
class CreateBox{
    public static void main(String[] args) {
        Box newBox = new Box("demoBox",20, 30, 50, 6000);
        newBox.param();
        Box newBox2 = new Box();
        newBox2.param();
    }
}