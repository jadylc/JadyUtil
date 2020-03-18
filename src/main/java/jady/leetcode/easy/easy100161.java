package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/03/16
 * https://leetcode-cn.com/problems/compress-string-lcci/
 */
@Slf4j
public class easy100161 {
    public static void main(String[] args) {
        log.info("result = {}",compressString("abbccd"));
    }

    public static String compressString(String S) {
        int N = S.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < N) {
            int j = i;
            while (j < N && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            sb.append(S.charAt(i));
            sb.append(j - i);
            i = j;
        }

        String res = sb.toString();
        if (res.length() < S.length()) {
            return res;
        } else {
            return S;
        }
    }
}
