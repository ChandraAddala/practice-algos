package practice.algos;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chan5120 on 4/16/17.
 */
public class DequeTryOut {

    public static void main(String[] args) {
        Deque<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.offer(4);
        q.addFirst(-1);

        System.out.println("peek=" + q.peek());
        System.out.println("peekLast=" + q.peekLast());
        System.out.println(Arrays.toString(q.toArray()));

        q.poll(); //FIFO
        System.out.println(Arrays.toString(q.toArray()));
     }
}
