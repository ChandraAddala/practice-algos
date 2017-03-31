package practice.algos;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int sumLastDigit = (l1.val + l2.val) % 10;
        int overflow = (l1.val + l2.val) / 10;
        ListNode output = new ListNode(sumLastDigit);

        ListNode l1Node = l1.next;
        ListNode l2Node = l2.next;
        while (l1Node != null && l2Node != null) {
            System.out.println(l1Node.val + "" + l2Node.val);
            sumLastDigit = (l1Node.val + l2Node.val + overflow) % 10;
            overflow = (l1Node.val + l2Node.val + overflow) / 10;

            output.next = new ListNode(sumLastDigit);

            l1Node = l1Node.next;
            l2Node = l2Node.next;
            output = output.next;
        }

        // if (l1Node != null) {
        //     while (l1Node != null) {
        //         sumLastDigit = (l1Node.val  + overflow) % 10;
        //         overflow = (l1Node.val + overflow) / 10;

        //         output.next = new ListNode(sumLastDigit);
        //         l1Node = l1.next;
        //     }
        // }

        // if (l2Node != null) {
        //     while (l2Node != null) {
        //         sumLastDigit = (l2Node.val  + overflow) % 10;
        //         overflow = (l2Node.val + overflow) / 10;

        //         output.next = new ListNode(sumLastDigit);
        //         l2Node = l2.next;
        //     }
        // }

        if (overflow > 0) {
            output.next = new ListNode(overflow);
        }

        return output;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers a = new AddTwoNumbers();
        a.addTwoNumbers(l1, l2);
    }
}

