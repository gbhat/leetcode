//https://leetcode.com/problems/implement-stack-using-queues/

import java.util.*;

public class ImplementStackUsingQueues {
    class MyStack {
        Queue<Integer> cur, other;

        public MyStack() {
            cur = new ArrayDeque<>();
            other = new ArrayDeque<>();

        }

        public void push(int x) {
            other.offer(x);
            while (cur.size() > 0)
                other.offer(cur.poll());
            Queue<Integer> temp = cur;
            cur = other;
            other = temp;
        }

        public int pop() {
            return cur.poll();
        }

        public int top() {
            return cur.peek();
        }

        public boolean empty() {
            return cur.size() == 0;
        }
    }
}