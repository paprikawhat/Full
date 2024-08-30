public class Stack {
    int[] stack = new int[10];
    int tos = -1;
    void push (int num) {
        if (num == 9) {
            System.out.println("Стек заполнен.");
        } else {
            stack[++tos] = num;
        }
    }

    int pop() {
            if (tos <=0) {
                System.out.println("Стек пустю");
                return 0;
            } else {
                return stack[tos--];
        }
    }
}
