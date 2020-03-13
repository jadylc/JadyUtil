package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuhan
 * @date 2020/03/13
 * https://leetcode-cn.com/problems/majority-element/
 */
@Slf4j
public class easy167 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        log.info("result = {}",majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1L, Long::sum);
        }
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Long v = entry.getValue();
            if (v > nums.length / 2) {
                return k;
            }
        }
        return 0;
    }
}
