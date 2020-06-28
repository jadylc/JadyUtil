package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/06/28
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
@Slf4j
public class medium209 {

    public static void main(String[] args) {
        log.info("result = {}",minSubArrayLen(7, new int[]{2,3,1,4,3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int i = 0, j = 0;

        int min = Integer.MAX_VALUE;
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int sum = nums[0];
        while (i < len){
            if(sum >= s){
                if(j - i + 1 < min){
                    min = j-i+1;
                    if(min == 1){
                        break;
                    }
                }
                sum = sum -nums[i];
                i+=1;
            }else if(j < len-1) {
                j += 1;
                sum = sum + nums[j];
            } else {
                break;
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
