package linear_data_structure.linked_list.add_two_numbers;

import linear_data_structure.linked_list.ListNode;

import java.math.BigInteger;

public class AddTwoNumbers {
    static ListNode reverseList(ListNode node) {
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    static BigInteger toBigInt(ListNode node) {
        StringBuilder val = new StringBuilder();
        while (node != null) {
            val.append(node.value);
            node = node.next;
        }
        return new BigInteger(val.toString());
    }

    static ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;
        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c), null);
            node.next = prev;
            prev = node;
        }
        return node;
    }

    static ListNode toReversedLinkedList2(BigInteger val) {
        ListNode node = new ListNode(-1, null);
        ListNode result = node;
        for (char c : String.valueOf(val).toCharArray()) {
            node.next = new ListNode(Character.getNumericValue(c), null);
            node = node.next;
        }

        return reverseList(result.next);
    }

    static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode list1Reversed = reverseList(list1);
        ListNode list2Reversed = reverseList(list2);

        BigInteger result = toBigInt(list1Reversed).add(toBigInt(list2Reversed));
        return toReversedLinkedList(result);
//        return toReversedLinkedList2(result);
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(2, null)));
        ListNode result = addTwoNumbers(list1, list2);
        System.out.println("result = " + result);
    }
}
