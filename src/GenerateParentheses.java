//https://leetcode.com/problems/generate-parentheses/

import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        generate(n, result, sb, 0, 0);
        return result;
    }

    private void generate(int n, List<String> result, StringBuilder sb, int left, int right) {
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            generate(n, result, sb, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generate(n, result, sb, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

