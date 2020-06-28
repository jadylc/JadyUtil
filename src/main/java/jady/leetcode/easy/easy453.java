package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/06/24
 */
@Slf4j
public class easy453 {
    public static void main(String[] args) {
        log.info("result = {}",minMoves(new int[]{83,86,77,15,93,35,86,92,49,21}));
    }


    public static int minMoves(int[] nums) {
        int result = 0;
        if(nums.length == 1){
            return result;
        }
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < min) {
                result += (min-num) * i;
                min = num;
            }else {
                result += (num -min);
            }
        }
        return result;
    }

}
