package jady.leetcode.easy;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liuhan
 * @date 2020/03/12
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 */
@Slf4j
public class easy1071 {
    public static void main(String[] args) {
        String str1 = "OBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGI";
        String str2 = "OBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGIOBAGPJGEEHODKLCPDMGI";
        long start = System.currentTimeMillis();
        log.info("result = {}",gcdOfStrings2(str1, str2));
        log.info("cost = {}",System.currentTimeMillis() - start);
    }

    public static String gcdOfStrings2(String str1, String str2) {
        if(str1.equals(str2)){
            return str1;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 == len2){
            return "";
        }else if(len1 > len2){
            if(str1.startsWith(str2)){
                return gcdOfStrings2(str2, str1.substring(len2));
            }else {
                return "";
            }
        }else {
            if(str2.startsWith(str1)){
                return gcdOfStrings2(str1, str2.substring(len1));
            }else {
                return "";
            }
        }
    }

    public static String gcdOfStrings(String str1, String str2) {
        Set<String> s1 = getDivisor(str1);
        Set<String> s2 = getDivisor(str2);
        String a = "";
        for (String n : s1) {
            if (s2.contains(n) && n.length() > a.length()) {
                a = n;
            }
        }
        return a;

    }
    private static Set<String> getDivisor(String str) {
        char[] chars = str.toCharArray();
        Set<String> strings = new HashSet<>();
        for (int i = 1; i < str.length(); i++) {
            if(chars[0] == chars[i]) {
                String t = str.substring(0, i);
                if (str.split(t).length == 0) {
                    strings.add(t);
                }
            }
        }
        strings.add(str);
        return strings;
    }
}
