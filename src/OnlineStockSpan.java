//https://leetcode.com/problems/online-stock-span/

import java.util.*;

// This gives TLE
public class OnlineStockSpan {
    class StockSpanner {

        List<Integer> list;
        public StockSpanner() {
            list = new LinkedList<>();
        }

        public int next(int price) {
            list.add(price);
            int count = 0;
            for(int i = list.size() - 1; i >= 0 && list.get(i) <= price; i--) {
                count++;
            }

            return count;
        }
    }
}
