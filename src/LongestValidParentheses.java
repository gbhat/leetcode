//https://leetcode.com/problems/longest-valid-parentheses/

import java.util.LinkedList;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int idx = stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            } else
                stack.push(i);
        }
        return max;
    }
}

