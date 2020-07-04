package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/06/29
 */
@Slf4j
public class medium215 {

    public static void main(String[] args) {
        log.info("result = {}",findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
