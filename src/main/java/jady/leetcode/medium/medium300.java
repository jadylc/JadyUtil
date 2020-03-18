package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/03/14
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
@Slf4j
public class medium300 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        log.info("result = {}",lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}
