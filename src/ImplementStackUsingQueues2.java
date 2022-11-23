//https://leetcode.com/problems/implement-stack-using-queues/

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues2 {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new ArrayDeque();
        }

        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            while(size > 1) {
                queue.offer(queue.poll());
                size--;
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.size() == 0;
        }
    }
}