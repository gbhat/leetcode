//https://leetcode.com/problems/integer-to-roman/

import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = buildMap();
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            Map.Entry<Integer, String> entry = map.floorEntry(num);
            sb.append(entry.getValue());
            num -= entry.getKey();
        }

        return sb.toString();

    }

    private TreeMap<Integer, String> buildMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        return map;
    }
}
