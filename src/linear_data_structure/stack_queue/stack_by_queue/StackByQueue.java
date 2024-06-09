package linear_data_structure.stack_queue.stack_by_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackByQueue {
    Queue<Integer> queue = new LinkedList<>();

    void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    int pop() {
        return queue.remove();
    }

    int top() {
        return queue.peek();
    }

    boolean empty() {
        return queue.isEmpty();
    }
}
