//https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class CheckSentencePangram2 {
    public boolean checkIfPangram(String sentence) {
        int result = 0;
        for(char ch : sentence.toCharArray())
            result |= 1 << (ch - 'a');

        return result == (1 << 26) - 1;
    }
}