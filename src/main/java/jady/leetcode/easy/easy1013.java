package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/03/11
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
@Slf4j
public class easy1013 {
    public static void main(String[] args) {
        int[] A = new int[]{1,-1,1,-1};
        log.info("result = {}",canThreePartsEqualSum(A));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int total = Arrays.stream(A).sum();
        if(total % 3 != 0){
            return false;
        }
        int part = total/3;
        int first = A[0];
        int firstI = 0;
        boolean firstP = false,secondP = false;
        for (int i1 = 1; i1 < A.length; i1++) {
            int i = A[i1];
            if (first == part) {
                firstI = i1;
                firstP = true;
                break;
            }else {
                first += i;
            }
        }
        if(!firstP){
            return false;
        }
        int second = A[firstI];
        for (int i2 = firstI+1; i2 < A.length; i2++) {
            int i = A[i2];
            if (second == part) {
                secondP = true;
                break;
            } else {
                second += i;
            }
        }
        return secondP;
    }

}
