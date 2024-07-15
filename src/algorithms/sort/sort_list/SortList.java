package algorithms.sort.sort_list;

import linear_data_structure.linked_list.ListNode;

public class SortList {
    static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.value < l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    static public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode half = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null;

        System.out.println("head = " + head);
        System.out.println("slow = " + slow);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return mergeTwoLists(l1, l2);
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, null)))));
        ListNode node = sortList(nodes);
        System.out.println("node = " + node);
    }
}
