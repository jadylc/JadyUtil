package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;


/**
 * Created by liuhan on 2020/3/9.
 * https://leetcode-cn.com/problems/super-ugly-number/
 */
@Slf4j
public class medium313 {
    public static void main(String[] args) {
        int[] primes = new int[]{2,7,13,19};
        log.info("result = {}",nthSuperUglyNumber(12, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        //丑数序列，下一个一定是现有序列中的一个乘以primes中的一个，记录primes中的每一个乘到序列中的哪一个了，所以下一个产生于四个备选乘积
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        dp[0] = 1;
        for(int i=1;i<n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<index.length;j++){
                dp[i]=Math.min(dp[i],primes[j]*dp[index[j]]);
            }

            for(int j=0;j<index.length;j++){
                if(primes[j]*dp[index[j]]==dp[i])
                    index[j]++;
            }
        }
        return dp[n-1];
    }
}
