//https://leetcode.com/problems/detect-capital/

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capCount = 0, smallCount = 0;
        for(char ch : word.toCharArray()) {
            if (smallCount > 0 && ch >= 'A' && ch <= 'Z')
                return false;
            else if (ch >= 'A' && ch <= 'Z')
                capCount++;
            else
                smallCount++;
        }
        if (capCount > 1 && smallCount > 0)
            return false;
        return true;
    }
}
