package Box;

public class CreateBox{
    public static void main(String[] args) {
        Box newBox = new Box(20, 30, 50, 6000);
        newBox.param();
        Box newBox2 = new Box();
        newBox2.param();
    }
}