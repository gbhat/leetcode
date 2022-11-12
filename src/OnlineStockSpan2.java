//https://leetcode.com/problems/online-stock-span/

import java.util.*;

public class OnlineStockSpan2 {
    class StockSpanner {
        List<int[]> list;           //Store the value of stock and the previous index at which there was a higher value
        public StockSpanner() {
            list = new LinkedList<>();
        }

        public int next(int price) {
            int count = 1;

            int i;
            for(i = list.size() - 1; i >= 0 && list.get(i)[0] <= price; i = list.get(i)[1])
                count += i - list.get(i)[1];
            list.add(new int[]{price, i});
            return count;
        }
    }

}
