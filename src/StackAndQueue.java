class StackNode {
    double x, y;
    StackNode next;
    public StackNode(double x, double y) {
        this.x = x;
        this.y = y;
        this.next = null;
    }
}
class Stack {
    private StackNode top;
    public Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(double x, double y) {
        StackNode newNode = new StackNode(x, y);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }
        top = top.next;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println("(" + current.x + ", " + current.y + ")");
            current = current.next;
        }

    }
}

class Queue {
    private static final int MAX_SIZE = 100;
    private String[][] elements;
    private int front, rear, size;

    public Queue() {
        this.elements = new String[MAX_SIZE][2];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public void enqueue(String name, String surname) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1) % MAX_SIZE;
        elements[rear][0] = name;
        elements[rear][1] = surname;
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        front = (front + 1) % MAX_SIZE;
        size--;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        int current = front;
        while (current != (rear + 1) % MAX_SIZE) {
            System.out.println("Name: " + elements[current][0] + ", Surname: " + elements[current][1]);
            current = (current + 1) % MAX_SIZE;
        }
    }
}


public class StackAndQueue {
    public static void main(String[] args) {
//Stack Structure
        Stack stack = new Stack();

        stack.push(1.5, 2.5);
        stack.push(3.0, 4.2);
        stack.push(5.8, 6.4);

        System.out.println("Stack elements:");
        stack.printStack();

        while(!stack.isEmpty()){
            stack.pop();
            System.out.println("\nAfter popping one element:");
            stack.printStack();
        }
        System.out.println();
// Stack Structure



//Queue Structure
        Queue queue = new Queue();

        queue.enqueue("Borys", "Grishny");
        queue.enqueue("Anatolii", "Shcherbak");
        queue.enqueue("John", "Week");

        System.out.println("Queue elements:");
        queue.printQueue();

        while(!queue.isEmpty()){
            queue.dequeue();
            System.out.println("\nAfter dequeueing one element:");
            queue.printQueue();
        }
//Queue Structure
    }
}