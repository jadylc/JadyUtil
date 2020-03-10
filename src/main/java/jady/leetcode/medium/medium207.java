package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuhan
 * @date 2020/03/07
 * https://leetcode-cn.com/problems/course-schedule/
 */
@Slf4j
public class medium207 {
    public static void main(String[] args) {
        int[][] pre = new int[2][2];
        pre[0][0] = 1;
        pre[0][1] = 0;
        pre[1][0] = 0;
        pre[1][1] = 1;
        log.info("result = {}",canFinish(2, pre));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean result = true;
        Map<Integer, Integer> map = new HashMap<>();
        if()
    }
}
