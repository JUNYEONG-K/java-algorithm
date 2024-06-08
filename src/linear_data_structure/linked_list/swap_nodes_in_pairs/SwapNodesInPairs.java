package linear_data_structure.linked_list.swap_nodes_in_pairs;

import linear_data_structure.linked_list.ListNode;

public class SwapNodesInPairs {
    static void swapPairsByChangingValue(ListNode node) {
        while (node != null) {
            int tmp = node.value;
            node.value = node.next.value;
            node.next.value = tmp;
            node = node.next.next;
        }
    }

    static ListNode swapPairsByChangingNextNode(ListNode head) {
        ListNode node = new ListNode(0, null);
        ListNode root = node;
        node.next = head;
        while (node.next != null && node.next.next != null) {
            ListNode a = node.next;
            ListNode b = node.next.next;
            a.next = b.next;
            node.next = b;
            node.next.next = a;
            node = node.next.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        swapPairsByChangingValue(node);
        System.out.println("node = " + node);
        ListNode swapped = swapPairsByChangingNextNode(node);
        System.out.println("swapped = " + swapped);
    }
}
