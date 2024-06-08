package linear_data_structure.linked_list.palindrome_linked_list;

import linear_data_structure.linked_list.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class PalindromeLinkedList {
    static boolean isPalindromeByStack(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();

        ListNode node = head;
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }

        while (head != null) {
            if (head.value != stack.pop()) return false;
            head = head.next;
        }

        return true;
    }

    static boolean isPalindromeByDeque(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.push(node.value);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (!Objects.equals(deque.pollFirst(), deque.pollLast())) return false;
//            if (deque.pollFirst() != deque.pollLast()) return false;
        }

        return true;
    }

    static boolean isPalindromeByRunner(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) slow = slow.next;

        ListNode rev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }

        while (rev != null) {
            if (rev.value != head.value) return false;
            rev = rev.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1, null)))));
//        boolean result = isPalindromeByStack(head);
//        boolean result = isPalindromeByDeque(head);
        boolean result = isPalindromeByRunner(head);
        System.out.println("result = " + result);
    }
}
