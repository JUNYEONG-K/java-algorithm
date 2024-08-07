package algorithms.sort.insertion_sort_list;

import linear_data_structure.linked_list.ListNode;

public class InsertionSortList {
    public static ListNode insertionSort(ListNode head) {
        ListNode parent = new ListNode(-1, null);
        ListNode p = parent;

        while (head != null) {
            while (p.next != null && p.next.value < head.value)
                p = p.next;
            ListNode pNext = p.next;
            ListNode headNext = head.next;
            p.next = head;
            head.next = pNext;
            head = headNext;

            if (head != null && p.value > head.value) p = parent;
        }
        return parent.next;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(5, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        ListNode node = insertionSort(nodes);
        System.out.println("node = " + node);
    }
}
