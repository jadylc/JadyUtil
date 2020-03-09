package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuhan on 2020/3/9.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
@Slf4j
public class easy121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        log.info("result = {}",maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2)
            return 0;
        int min = 0;
        int temp = prices[0];
        for (int i = 1; i < len; i++) {
            if(prices[i] <= temp){
                temp = prices[i];
            }else {
                if(prices[i] - temp > min){
                    min = prices[i] - temp;
                }
            }
        }
        return min;
    }
}
