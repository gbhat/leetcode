//https://leetcode.com/problems/interleaving-string/

import java.util.*;

public class InterleavingString2 {
    class VO {
        public int i, j, k;
        public VO(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public int hashCode() {
            return i + j + k;
        }

        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if(obj == null || obj.getClass()!= this.getClass())
                return false;

            VO vo = (VO) obj;

            return vo.i == this.i && vo.j == this.j && vo.k == this.k;
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;

        int i = s1.length() - 1, j = s2.length() - 1, k = s3.length() - 1;
        HashMap<VO, Boolean> map = new HashMap<>();

        return check(s1, s2, s3, map, i, j, k);
    }

    private boolean check(String s1, String s2, String s3, HashMap<VO, Boolean> map, int i, int j, int k) {
        if (k < 0 && i < 0 && j < 0)
            return true;

        VO vo = new VO(i, j, k);

        if (k < 0) {
            map.put(vo, false);
            return false;
        }

        if (map.containsKey(vo))
            return map.get(vo);


        boolean ret = false;
        if (i >= 0 && s1.charAt(i) == s3.charAt(k) && j >= 0 && s2.charAt(j) == s3.charAt(k))
            ret = check(s1, s2, s3, map, i - 1, j, k - 1) || check(s1, s2, s3, map,  i, j - 1, k - 1);
        else if (i >= 0 && s1.charAt(i) == s3.charAt(k))
            ret = check(s1, s2, s3,  map, i - 1, j, k - 1);
        else if (j >= 0 && s2.charAt(j) == s3.charAt(k))
            ret =  check(s1, s2, s3,  map, i, j - 1, k - 1);

        map.put(vo, ret);
        return ret;
    }
}