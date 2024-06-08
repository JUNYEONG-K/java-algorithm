package linear_data_structure.linked_list.odd_even_linked_list;

import linear_data_structure.linked_list.ListNode;

public class OddEvenLinkedList {
    static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        ListNode result = oddEvenList(node);
        System.out.println("result = " + result);
    }
}
