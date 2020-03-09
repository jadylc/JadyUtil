package jady.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/03/07
 */
@Slf4j
public class easy541 {
    public static void main(String[] args) {
        log.info("result = {}",reverseStr("abcdefghij",4));
    }

    public static String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        if(k>=ss.length){
            swap(ss, 0, ss.length-1);
            return new String(ss);
        }
        int lc = 0;
        for (int i = 0; i < ss.length; i++) {
            lc+=1;
            if(lc == 2*k){
                lc = 0;
            } else if(lc == k){
                swap(ss, i-k+1, i);
            }
        }
        if(lc < k && lc > 0){
            swap(ss, ss.length-lc, ss.length-1);
        }
        return new String(ss);
    }

    public static void swap(char[] ss, int start, int end){
        for(int i = start; i< (start+end+1)/2;i++){
            char t = ss[i];
            ss[i] = ss[end-i+start];
            ss[end-i+start] = t;
        }
    }
}
