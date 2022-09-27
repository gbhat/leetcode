//https://leetcode.com/problems/push-dominoes/

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        for(int i = 0; i < dominoes.length(); i++) {
            //If we encounter a 'L', count how many '.' are there to the left.
            if (dominoes.charAt(i) == 'L') {
                int cnt = 0;
                int j = i - 1;
                while(j >= 0 && dominoes.charAt(j) == '.') {
                    cnt++;
                    j--;
                }
                if (j >= 0 && dominoes.charAt(j) == 'R') {  // If we have 'R' at the end of this left side, then only half of them should be marked as 'L'
                    cnt /= 2;
                }
                for(j = 1; j <= cnt; j++)
                    sb.setCharAt(i - j, 'L');
            }

            //If we encounter a 'R', count how many '.' are there to the right.
            if (dominoes.charAt(i) == 'R') {
                int cnt = 0;
                int j = i + 1;
                while(j < dominoes.length() && dominoes.charAt(j) == '.') {
                    cnt++;
                    j++;
                }
                if (j < dominoes.length() && dominoes.charAt(j) == 'L') { // If we have 'L' at the end of this right side, then only half of them should be marked as 'R'
                    cnt /= 2;
                }
                for(j = 1; j <= cnt; j++)
                    sb.setCharAt(i + j, 'R');
            }
        }
        return sb.toString();
    }
}