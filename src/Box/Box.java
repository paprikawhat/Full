package src.Box;

class Box {
    // ОБЪЯВЛЕНИЕ ПАРАМЕТРОВ И МЕТОДОВ
    String name = "";
    Inside inside = new Inside();
    private double height;
    final void setHeight(double n) {
        height = n;
    }
    private double width;
    final void setWidth(double n) {
        width = n;
    }
    private double depth;
    final void setDepth(double n) {
        depth = n;
    }
    private double weight;
    final void setWeight(double n) {
        weight = n;
    }
    private float price;
    void setPrice(float n) {
        price = (float) n;
    }
    private boolean isEasy;
    boolean e() {
        isEasy = (weight <= 10000) &&
                (height + width + depth < 150) &&
                (height < 100 && width < 100 && depth < 100);
        return isEasy;
    }
    void volume() {
        double v = height * width * depth;
        System.out.println("Объём коробки: " + v / 1000 + " литров");
    }
    void param() {
        System.out.println("Создана коробка: " + this.name);
        System.out.println("Размеры: " + height + " x " + width + " x " + depth + "\nВес: " + weight / 1000 + " кг.");
        if (e()) {
            System.out.println("Отправить!");
        } else {
            System.out.println("Сложность с отправлением.");
        }
        System.out.println("Цена отправления: " + price);
    }
    Box(Box ob) {// КОНСТРУКТОР ДЛЯ КЛОНИРОВАНИЯ
        name = ob.name;
        height = ob.height;
        width = ob.width;
        depth = ob.depth;
        weight = ob.weight;
        price = ob.price;
        isEasy = ob.isEasy;
        inside = ob.inside;
    }
    Box() { // КОНСТРУКТОР ПО-УМОЛЧАНИЮ
        name = "Пустое место.";
        height = -1;
        width = -1;
        depth = -1;
        weight = -1;
        price = 0;
        inside.push("");
    }
    Box(String n, String str, double h, double w, double d, double wh) { // КОНСТРУКТОР С УКАЗАНИЕМ РАЗМЕРОВ
        inside.push(str);
        name = n;
        height = h;
        width = w;
        depth = d;
        weight = wh;
    }

    static class BoxCreateDemo {
        public static void main(String[] args) {
            Box newBox = new Box("demoBox", "Печенье.", 20, 30, 50, 16000);
            newBox.param();
            Box newBox2 = new Box();
            newBox2.param();
        }
    }
    // Класс внутреннего содержания коробки
    static class Inside {
        String[] inside ;
        private int tos;
        Inside() {
            inside = new String[1];
            tos = -1;
        }
        final void push(String in) {
            if (tos == inside.length - 1) {
                String[] temp = new String[inside.length * 2];
                for (int i = 0; i < tos; i++) {
                    temp[i] = inside[i];
                    inside = temp;
                }
            } else inside[++tos] = in;
        }

        final String pop() {
            if (tos <= 0) {
                return "Коробка пуста.";
            } else {
                return inside[tos--];
            }
        }
    }
}
