package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/06/24
 * https://leetcode-cn.com/problems/3sum-closest/
 */
@Slf4j
public class medium16 {
    public static void main(String[] args) {
        log.info("result = {}",threeSumClosest(new int[]{1,1,-1,-1,3},3));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(bestSum-target) > Math.abs(sum-target)) {
                    bestSum = sum;
                }
                if(sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return bestSum;

        /*int len = nums.length;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int c = 2; c < len; c++) {
            for(int b = 1; b < c; b++){
                for(int a = 0; a < b; a++){
                    int total = nums[a] + nums[b] + nums[c] - target;
                    if(Math.abs(total) < result){
                        result = Math.abs(total);
                        sum = total + target;
                    }
                }
            }
        }
        return sum;*/
    }
}
