package practice.algos;


public class ReverseLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode input) {

        ListNode head = new ListNode(0);
        reverseInternal(input, head);
        return head.next;
    }

    private static void reverseInternal(ListNode first, ListNode head) {

        /**
         * head has the reverse of the part of linked link that was traversed so far.
         */

        if (first == null) return;

        if (first.next == null) {
            first.next = head.next;
            head.next = first;
            return;
        }

        ListNode second = first.next;
        ListNode third = first.next.next;

        first.next = head.next;
        second.next = first;
        head.next = second;

        reverseInternal(third, head);
    }

    private static void print(ListNode head) {
        ListNode start = head;
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
        System.out.println("");
    }


    public static ListNode reverseIterate(ListNode head) {
        if (head == null || head.next == null) return head;


        ListNode reverseHead = new ListNode(0);
        reverseHead.next = head;
        ListNode last = head;
        ListNode node = head.next;
        while (node != null) {
            last.next = node.next;
            node.next = reverseHead.next;
            reverseHead.next = node;

            node = last.next;
        }


        return reverseHead.next;
    }


    public static void main(String[] args) {
        ListNode start = new ListNode(0);
        start.next = new ListNode(1);
        start.next.next = new ListNode(2);
        start.next.next.next = new ListNode(3);
        start.next.next.next.next = new ListNode(4);

        print(start);
//        print(reverse(start));

        print(reverseIterate(start));

    }
}
