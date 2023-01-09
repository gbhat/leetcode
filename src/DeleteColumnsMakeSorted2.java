//https://leetcode.com/problems/delete-columns-to-make-sorted/

public class DeleteColumnsMakeSorted2 {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)) {
                    count++;
                    break;
                }
            }
            System.out.println();
        }
        return count;
    }
}