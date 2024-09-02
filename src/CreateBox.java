public class CreateBox {
    public static void main(String[] args) {
        System.out.println("Корбка создвна");
        Box newBox = new Box(50, 20, 30, 500);
        newBox.param();
        Box newBox2 = new Box();
        newBox2.param();
    }
}