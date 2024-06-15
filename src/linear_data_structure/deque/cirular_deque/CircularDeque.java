package linear_data_structure.deque.cirular_deque;

public class CircularDeque {
    int length;
    int k;

    DoublyLinkedList head;
    DoublyLinkedList tail;

    public CircularDeque(int k) {
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        head.right = tail;
        tail.left = head;
        this.k = k;
        length = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        DoublyLinkedList node = new DoublyLinkedList(value);
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
        length++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        DoublyLinkedList node = new DoublyLinkedList(value);
        node.left = tail.left;
        node.right = tail;
        tail.left.right = node;
        tail.left = node;
        length++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        head.right.right.left = head;
        head.right = head.right.right;
        length--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        tail.left.left.right = tail;
        tail.left = tail.left.left;
        length--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.right.value;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.left.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == k;
    }

    static class DoublyLinkedList {
        DoublyLinkedList left;
        DoublyLinkedList right;
        int value;

        public DoublyLinkedList(int value) {
            this.value = value;
        }
    }
}
