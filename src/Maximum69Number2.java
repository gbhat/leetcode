//https://leetcode.com/problems/maximum-69-number/

import java.util.*;

public class Maximum69Number2 {
    public int maximum69Number (int num) {
        Stack<Integer> stack = new Stack<>();
        while(num != 0) {
            stack.push(num % 10);
            num = num / 10;
        }
        boolean first = true;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            if (top == 6 && first) {
                top = 9;
                first = false;
            }
            num = num * 10 + top;
        }
        return num;
    }
}




