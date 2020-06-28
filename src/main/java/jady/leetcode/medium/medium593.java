package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/06/24
 * https://leetcode-cn.com/problems/valid-square/submissions/
 */
@Slf4j
public class medium593 {

    public static void main(String[] args) {
        log.info("result = {}",validSquare(new int[]{1,0}, new int[]{-1,0}, new int[]{0,1}, new int[]{0,-1}));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean result = true;
        int[][] sortedPoint = new int[4][2];
        sortedPoint = sort(p1,p2,p3,p4);
        long[] line = new long[]{distance(sortedPoint[0],sortedPoint[1]),distance(sortedPoint[1],sortedPoint[2]),distance(sortedPoint[2],sortedPoint[3]),distance(sortedPoint[0],sortedPoint[3])};
        long temp = -1;
        for (long l : line) {
            if(l == 0){
                result = false;
                break;
            }
            if(temp < 0){
                temp = l;
            }
            if(temp != l){
                result = false;
                break;
            }
        }
        if(!result){
            return result;
        }
        line = new long[]{distance(sortedPoint[0],sortedPoint[2]),distance(sortedPoint[1],sortedPoint[3])};
        temp = -1;
        for (long l : line) {
            if(temp < 0){
                temp = l;
            }
            if(temp != l){
                result = false;
                break;
            }
        }
        return result;
    }

    public static long distance(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) +(p1[1]-p2[1])*(p1[1]-p2[1]);
    }


    public static int[][] sort(int[] p1, int[] p2, int[] p3, int[] p4){
        int[][] sortedPoint = new int[4][2];
        sortedPoint[0] = getleftdown(p1,p2,p3,p4);
        sortedPoint[1] = getrightdown(p1,p2,p3,p4);
        sortedPoint[2] = getrightup(p1,p2,p3,p4);
        sortedPoint[3] = getleftup(p1,p2,p3,p4);
        return sortedPoint;
    }
    public static int[] getleftdown(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] result = p1;
        if(p2[1] < result[1] || (p2[1] == result[1] && p2[0] < result[0])){
            result = p2;
        }
        if(p3[1] < result[1] || (p3[1] == result[1] && p3[0] < result[0])){
            result = p3;
        }
        if(p4[1] < result[1] || (p4[1] == result[1] && p4[0] < result[0])){
            result = p4;
        }
        return result;
    }
    public static int[] getrightdown(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] result = p1;
        if((p2[1] < result[1] && p2[0] == result[0]) || p2[0] > result[0]){
            result = p2;
        }
        if((p3[1] < result[1] && p3[0] == result[0]) || p3[0] > result[0]){
            result = p3;
        }
        if((p4[1] < result[1] && p4[0] == result[0]) || p4[0] > result[0]){
            result = p4;
        }
        return result;
    }
    public static int[] getleftup(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] result = p1;
        if((p2[1] > result[1] && p2[0] == result[0]) || p2[0] < result[0]){
            result = p2;
        }
        if((p3[1] > result[1] && p3[0] == result[0]) || p3[0] < result[0]){
            result = p3;
        }
        if((p4[1] > result[1] && p4[0] == result[0]) || p4[0] < result[0]){
            result = p4;
        }
        return result;
    }
    public static int[] getrightup(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] result = p1;
        if(p2[1] > result[1] || (p2[0] > result[0] && p2[1] == result[1])){
            result = p2;
        }
        if(p3[1] > result[1] || (p3[0] > result[0] && p3[1] == result[1])){
            result = p3;
        }
        if(p4[1] > result[1] || (p4[0] > result[0] && p4[1] == result[1])){
            result = p4;
        }
        return result;
    }

}
