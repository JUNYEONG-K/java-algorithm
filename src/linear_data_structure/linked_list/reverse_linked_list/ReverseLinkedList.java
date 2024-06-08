package linear_data_structure.linked_list.reverse_linked_list;

import linear_data_structure.linked_list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseLinkedList {
    static ListNode reverseByStack(ListNode node) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }

        ListNode result = new ListNode(0, null);
        ListNode output = result;
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            result.next = new ListNode(pop, null);
            result = result.next;
        }
        return output.next;
    }

    static ListNode reverseByRecursion(ListNode node, ListNode prev) {
        if (node == null) return prev;
        ListNode next = node.next;
        node.next = prev;
        return reverseByRecursion(next, node);
    }

    static ListNode reverseForWhile(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            System.out.println("node.next1 = " + node.next);
            node.next = prev;
            System.out.println("node.next2 = " + node.next);
            prev = node;
            node = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode reverseByStack = reverseByStack(node);
        ListNode reverseForWhile = reverseForWhile(node);
        System.out.println("reverseByStack = " + reverseByStack);
        System.out.println("reverseForWhile = " + reverseForWhile);
    }
}
