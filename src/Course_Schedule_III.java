//https://leetcode.com/problems/course-schedule-iii/

import java.util.Arrays;

// Recursive solution. Not accepted. Check Course_Schedule_III3.java, Course_Schedule_III4.java
public class Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        return maxCourse(courses, 0, 0);
    }

    private int maxCourse(int[][] courses, int curDay, int idx) {
        if (idx >= courses.length)
            return 0;

        int max = 0;
        for(int i = idx; i < courses.length; i++) {
            if (curDay + courses[i][0] <= courses[i][1]) {
                max = Math.max(max, 1 + maxCourse(courses, curDay + courses[i][0], i + 1));
            }
        }
        return max;
    }
}
