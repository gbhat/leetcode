//https://leetcode.com/problems/design-circular-queue/

public class DesignCircularQueue2 {
    class MyCircularQueue {
        int[] queue;
        int k;
        int head = 0, size = 0;

        public MyCircularQueue(int k) {
            queue = new int[k];
            head = 0;
            size = 0;
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;
            queue[(head + size) % k] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;
            int val = queue[head];
            head = (head + 1) % k;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[(head + size - 1) % k];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }
    }
}
