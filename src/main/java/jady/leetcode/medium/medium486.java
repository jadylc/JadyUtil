package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/03/13
 * https://leetcode-cn.com/problems/predict-the-winner/
 */
@Slf4j
public class medium486 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,3,2,5,1};
        log.info("result = {}",PredictTheWinner(nums));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if(len<3){
            return true;
        }
        int[] result = getMaxSum(nums, 0, len-1, 0, 0,1);
        return result[0] >= result[1];
    }

    private static int[] getMaxSum(int[] nums, int start, int end, int a, int b, int c){
        int[] result = new int[]{a,b};
        if(end - start == 0){
            result = plus(result, nums[start], c);
        }else if(end - start > 0){
            int[] planA = plus(result, nums[start], c);
            int[] temppa = getMaxSum(nums, start+1, end, planA[0], planA[1], -c);
            int[] planB = plus(result, nums[end], c);
            int[] temppb = getMaxSum(nums, start, end-1, planB[0],planB[1],-c);
            result = check(temppa, temppb, c);
        }
        return result;
    }

    private static int[] check(int[] temppa, int[] temppb,int c){
        if(c >0){
            if(temppa[0]-temppa[1] >= temppb[0]-temppb[1]){
                return temppa;
            }else {
                return temppb;
            }
        }else {
            if(temppa[1]-temppa[0] >= temppb[1]-temppb[0]){
                return temppa;
            }else {
                return temppb;
            }
        }

    }

    private static int[] plus(int[] rs, int plusNumber, int c){
        int[] after = new int[]{rs[0],rs[1]};
        if(c > 0){
            after[0] += plusNumber;
        }else {
            after[1] += plusNumber;
        }
        return after;
    }


}

