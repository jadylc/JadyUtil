package jady.leetcode.hard;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuhan
 * @date 2020/07/04
 * https://leetcode-cn.com/problems/xun-bao/
 */
@Slf4j
public class hard_LCP13 {
    static AtomicInteger result = new AtomicInteger(0);
    static List<Integer> S = new ArrayList<>();
    static List<Integer> T = new ArrayList<>();
    static List<Integer> CURRENT = new ArrayList<>();
    static List<List<Integer>> O = new ArrayList<>();
    static List<List<Integer>> M = new ArrayList<>();
    static List<List<Integer>> WALL = new ArrayList<>();
    public static void main(String[] args) {
        log.info("result = {}", minimalSteps(new String[]{"S#O", "M..", "M.T"}));
    }
    public static int minimalSteps(String[] maze) {
        char[][] map = initMap(maze,S,T,O,M,WALL);
        //处理所有的M
        handleM();

        return result.get();
    }

    public static void handleM(){
        while(!M.isEmpty()){
            //找到最近的O
            List<Integer> nearestO = new ArrayList<>();
            int minStepToO = Integer.MAX_VALUE;
            O.forEach(os -> {
                int step = getDistance(os, CURRENT);
                if(step < minStepToO){
                    nearestO.
                }
            });
        }
    }

    public static int getDistance(List<Integer> start, List<Integer> end){

    }

    public static char[][] initMap(String[] maze, List<Integer> S, List<Integer> T, List<List<Integer>> O, List<List<Integer>> M, List<List<Integer>> WALL){
        int len = maze[0].length();
        int high = maze.length;
        char[][] map = new char[len][high];
        for (int i = 0; i < high; i++) {
            String row = maze[i];
            char[] rows = row.toCharArray();
            for (int i1 = 0; i1 < rows.length; i1++) {
                char rowChar = rows[i1];
                map[i][i1] = rowChar;
                if(rowChar == 'S'){
                    S.add(i);
                    S.add(i1);
                    CURRENT = S;
                }else if(rowChar == 'T'){
                    T.add(i);
                    T.add(i1);
                } else if (rowChar == 'O') {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(i1);
                    O.add(temp);
                } else if (rowChar == 'M') {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(i1);
                    M.add(temp);
                } else if (rowChar == '#') {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(i1);
                    WALL.add(temp);
                }
            }
        }
        return map;
    }
}
