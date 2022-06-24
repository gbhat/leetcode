//https://leetcode.com/problems/course-schedule-iii/

import java.util.Arrays;

// Recursive solution. Not accepted. Check Course_Schedule_III3.java, Course_Schedule_III4.java
public class Course_Schedule_III2 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        return maxCourse(courses, 0, 0);
    }

    private int maxCourse(int[][] courses, int curDay, int idx) {
        if (idx >= courses.length)
            return 0;

        int withThisCourse = 0;
        int withoutThisCourse = 0;
        if (curDay + courses[idx][0] <= courses[idx][1]) {
            withThisCourse = 1 + maxCourse(courses, curDay + courses[idx][0], idx + 1);
        }
        withoutThisCourse = maxCourse(courses, curDay, idx + 1);

        return Math.max(withThisCourse, withoutThisCourse);
    }
}
