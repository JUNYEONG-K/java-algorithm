package linear_data_structure.priority_queue.merge_k_sorted_lists;

import linear_data_structure.linked_list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static ListNode mergeLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.value)));

        ListNode root = new ListNode(0, null);
        ListNode tail = root;

        for (ListNode list : lists)
            if (list != null) pq.add(list);

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            System.out.println("pq.poll() = " + tail.next);
            tail = tail.next;

            if (tail.next != null) pq.add(tail.next);
        }

        return root.next;
    }

    static ListNode mergeLists2(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> {
            if (o1.value == o2.value) return 0;
            if (o1.value > o2.value) return 1;
            return -1;
        }));

        for (ListNode list : lists)
            if (list != null) pq.add(list);


        ListNode root = new ListNode(0, null);
        ListNode tail = root;
        while (!pq.isEmpty()) {
            ListNode polled = pq.poll();
            tail.next = new ListNode(polled.value, null);
            tail = tail.next;
            if (polled.next != null) pq.add(polled.next);
        }

        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode l3 = new ListNode(2, new ListNode(7, null));

        ListNode merged = mergeLists2(new ListNode[]{l1, l2, l3});
        System.out.println("merged = " + merged);
    }
}
