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
        //丑数序列
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
