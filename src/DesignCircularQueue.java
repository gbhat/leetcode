//https://leetcode.com/problems/design-circular-queue/

public class DesignCircularQueue {
    class MyCircularQueue {
        int[] queue;
        int k;
        int front = -1, back = -1, total = 0;

        public MyCircularQueue(int k) {
            queue = new int[k];
            front = -1;
            back = -1;
            total = 0;
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (total == k)
                return false;
            front = (front + 1) % k;
            queue[front] = value;
            total++;
            return true;
        }

        public boolean deQueue() {
            if (total <= 0)
                return false;
            back = (back + 1) % k;
            int val = queue[back];
            total--;
            return true;
        }

        public int Front() {
            return total <= 0 ? -1 : queue[(back + 1) % k];
        }

        public int Rear() {
            return total <= 0 ? -1 : queue[front];
        }

        public boolean isEmpty() {
            return total == 0;
        }

        public boolean isFull() {
            return total == k;
        }
    }
}
