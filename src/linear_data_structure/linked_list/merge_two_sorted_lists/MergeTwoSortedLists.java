package linear_data_structure.linked_list.merge_two_sorted_lists;

import linear_data_structure.linked_list.ListNode;

public class MergeTwoSortedLists {
    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            System.out.println("1. return: " + list2);
            return list2;
        }
        if (list2 == null) {
            System.out.println("2. return: " + list1);
            return list1;
        }

        if (list1.value < list2.value) {
            list1.next = mergeTwoLists(list1.next, list2);
            System.out.println("3. return: " + list1);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            System.out.println("4. return: " + list2);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(5, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.println("merged = " + merged);
    }
}
