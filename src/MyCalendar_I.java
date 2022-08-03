//https://leetcode.com/problems/my-calendar-i/

import java.util.*;

public class MyCalendar_I {
    TreeMap<Integer, Integer> map;
    public MyCalendar_I() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prev = map.floorEntry(start);
        Map.Entry<Integer, Integer> next = map.ceilingEntry(start);

        if ((prev == null || prev.getValue() <= start) &&   // If prev schedule is not there, or previous end time is less than or equal to current start time
                (next == null || end <= next.getKey())) {   // If next schedule is not there, or next start time is greater than equal to current end time
            map.put(start, end);
            return true;
        }
        return false;
    }
}
