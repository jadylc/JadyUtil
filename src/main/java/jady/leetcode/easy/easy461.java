package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2020/06/23
 * https://leetcode-cn.com/problems/hamming-distance/
 */
@Slf4j
public class easy461 {
    public static void main(String[] args) {
        log.info("result = {}",hammingDistance(7,4));
    }

    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        int r = 0;
        while (z > 0){
            if(z % 2 != 0){
                r+=1;
            }
            z = z/2;
        }
        return r;
    }
}
