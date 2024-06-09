package linear_data_structure.stack_queue.circular_queue;

public class CircularQueue {
    int[] q;
    int front = 0, rear = -1, len = 0;

    public CircularQueue(int k) {
        q = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        rear = (rear + 1) % q.length;
        q[rear] = value;
        len++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % q.length;
        len--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == q.length;
    }
}
