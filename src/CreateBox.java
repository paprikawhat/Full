public class CreateBox {
    public static void main(String[] args) {
        System.out.println("Корбка создвна");
        Box newBox = new Box(50, 20, 30, 500);
        System.out.println("Размеры: 30 x 50 x 20\nВес:500");
        if (newBox.isEasy) {
            System.out.println("Отправить!");
        } else {
            System.out.println("Сложность с отправлением.");
        }

    }
}