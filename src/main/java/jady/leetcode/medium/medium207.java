package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author liuhan
 * @date 2020/03/07
 * https://leetcode-cn.com/problems/course-schedule/
 * 广度优先/深度优先
 */
@Slf4j
public class medium207 {
    public static void main(String[] args) {
        int[][] pre = new int[4][2];
        pre[0][0] = 1;
        pre[0][1] = 0;
        pre[1][0] = 2;
        pre[1][1] = 1;
        pre[2][0] = 1;
        pre[2][1] = 3;
        pre[3][0] = 3;
        pre[3][1] = 2;

        log.info("result = {}",canFinish1(4, pre));
    }

    public static boolean canFinish1(int numCourses, int[][] prerequisites){
        int[] indegrees = new int[numCourses];
        for(int[] cp : prerequisites) {
            indegrees[cp[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) {
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {
                if(req[0] != pre) {
                    continue;
                }
                if(--indegrees[req[1]] == 0) {
                    queue.add(req[1]);
                }
            }
        }
        return numCourses == 0;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites) {
            adjacency[cp[1]][cp[0]] = 1;
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }
    private static boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) {
            return false;
        }
        if(flags[i] == -1) {
            return true;
        }
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }
}

