//https://leetcode.com/problems/ugly-number/

public class UglyNumber2 {
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        if (n <= 3)
            return true;
        int cur = 2;
        while(n != 1 && cur <= 5) {
            if (n % cur == 0)
                n = n / cur;
            else
                cur++;
        }

        return cur <= 5;

    }
}