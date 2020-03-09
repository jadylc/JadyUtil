package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liuhan
 * @date 2019/09/26
 * https://leetcode-cn.com/problems/arranging-coins/
 */
@Slf4j
public class easy441 {
    public static void main(String[] args) {
        log.info("result = {}",arrangeCoins(9));
    }

    public static int arrangeCoins(int n) {
        int line = 0;
        while (n > line){
            n = n - (++line);
        }
        return line;
    }
}
