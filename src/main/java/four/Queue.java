package four;

public class Queue {
    private int front;
    private int rear;
    private int size;
    private int[] queue;

    public Queue(int size) {
        this.size = size;
        this.front = 0;
        this.rear = -1;
        queue = new int[size];
    }

    public boolean full() {
        return (rear == size - 1);
    }

    public boolean empty() {
        return (front == (rear + 1));
    }

    public boolean add(int item) {
        if (full()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        queue[++rear] = item;
        return true;
    }

    public int peek() {
        if (empty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return queue[front];
    }

    public void print() {
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.print();

        int peek = queue.peek();
        System.out.println("peek: " + peek);



    }


}
