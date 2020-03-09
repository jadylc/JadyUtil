package jady.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by liuhan on 2020/3/8.
 */
@Slf4j
public class medium322 {
    public static void main(String[] args) {
        int[] coins = new int[]{186,419,83,408};
        log.info("result = {}",coinChange(coins,6249));
    }
    //全局变量，保存当前最少值
    static int minCount = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private static void recursion(int[] coins, int amount, int count, int index) {
        //index非法中止，大于当前最优解快速失败
        if (index < 0 || count + amount / coins[index] >= minCount) {
            return;
        }
        //有解的时候判断是否更新最优解
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        //无解的时候，穷举
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }



}
