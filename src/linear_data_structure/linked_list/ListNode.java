package linear_data_structure.linked_list;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " -> " + next;
//        return "ListNode{" +
//                "value=" + value +
//                ", next=" + next +
//                '}';
    }
}
