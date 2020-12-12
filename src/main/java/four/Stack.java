package four;


public class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        top = -1;
    }

    public void push(int data) {
        if (full()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        stack[++top] = data;
    }

    private boolean full() {
        return (top == size - 1);
    }

    public int pop() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return stack[top--];
    }

    private boolean empty() {
        return (top == -1);
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();

        int pop = stack.pop();
        System.out.println("pop: " + pop);
    }
}
