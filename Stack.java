class Stack {
    int[] stack;
    int tos;
    Stack(int size) { //ИНИЦИАЛИЗАЦИЯ МАССИВА
        stack = new int[size];
        tos = -1;
    }
    void push (int num) {
        if (num == stack.length) {
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
