//https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class CheckSentencePangram3 {
    public boolean checkIfPangram(String sentence) {
        return sentence.chars().distinct().count()  == 26;
    }
}