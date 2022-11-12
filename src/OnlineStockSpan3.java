//https://leetcode.com/problems/online-stock-span/

import java.util.*;

public class OnlineStockSpan3 {
    class StockSpanner {
        Stack<int[]> stack = new Stack<>();

        public int next(int price) {
            int ans = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                ans += stack.pop()[1];
            }

            stack.push(new int[] {price, ans});
            System.out.print(price + " ");
            for(int[] p : stack)
                System.out.print(Arrays.toString(p) + " ");
            System.out.println();
            return ans;
        }
    }
}
