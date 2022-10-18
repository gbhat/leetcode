//https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 0; i < n - 1; i++) {
            str = countAndSay(str);
        }
        return str;
    }

    private String countAndSay(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            int curNo = str.charAt(i) - '0';
            i++;
            int count = 1;
            while(i < str.length() && str.charAt(i - 1) == str.charAt(i)) {
                count++;
                i++;
            }
            sb.append(count).append(curNo);
        }
        return sb.toString();
    }
}