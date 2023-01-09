//https://leetcode.com/problems/delete-columns-to-make-sorted/

public class DeleteColumnsMakeSorted {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (ch > strs[j].charAt(i)) {
                    count++;
                    break;
                }
                ch = strs[j].charAt(i);
            }
            System.out.println();
        }
        return count;
    }
}