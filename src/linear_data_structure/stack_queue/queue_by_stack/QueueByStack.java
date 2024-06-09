package linear_data_structure.stack_queue.queue_by_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueByStack {
    Deque<Integer> input = new ArrayDeque<>();
    Deque<Integer> output = new ArrayDeque<>();

    void push(int x) {
        input.push(x);
    }

    int pop() {
        peek();
        return output.pop();
    }

    int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
