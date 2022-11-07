//https://leetcode.com/problems/maximum-69-number/

public class Maximum69Number3 {
    boolean first = true;
    int result;
    public int maximum69Number (int num) {
        max69Num(num);
        return result;
    }

    private void max69Num(int num) {
        if (num == 0)
            return;
        max69Num(num / 10);
        int dec = num % 10;
        if (first && dec == 6) {
            dec = 9;
            first = false;
        }
        result = result * 10 + dec;
    }
}
