package jady.leetcode.hard;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;

/**
 * @author liuhan
 * @date 2020/07/04
 */
@Slf4j
public class hard32 {

    public static void main(String[] args) {
        log.info("result = {}",longestValidParentheses("))))())()()(()"));
    }

    public static int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        return Math.max(left(chars), right(chars));
    }

    public static int left(char[] chars){
        int result = 0;
        int cur = 0;
        int status = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(status == 0){
                if(aChar == '('){
                    status += 1;
                    cur += 1;
                }else {
                    cur += temp;
                    if(cur > result){
                        result = cur;
                    }
                    cur = 0;
                    temp = 0;
                }
            }else if(status > 0){
                if(aChar == '('){
                    status += 1;
                    cur += 1;
                }else {
                    status -= 1;
                    cur += 1;
                    if(status == 0){
                        temp += cur;
                        cur = 0;
                    }
                }
            }
        }
        if(status == 0){
            return Math.max(result, temp + cur);
        }else {
            return Math.max(result,temp);
        }
    }
    public static int right(char[] chars){
        int result = 0;
        int cur = 0;
        int status = 0;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[chars.length-1-i];
            if(status == 0){
                if(aChar == ')'){
                    status += 1;
                    cur += 1;
                }else {
                    cur += temp;
                    if(cur > result){
                        result = cur;
                    }
                    cur = 0;
                    temp = 0;
                }
            }else if(status > 0){
                if(aChar == ')'){
                    status += 1;
                    cur += 1;
                }else {
                    status -= 1;
                    cur += 1;
                    if(status == 0){
                        temp += cur;
                        cur = 0;
                    }
                }
            }
        }
        if(status == 0){
            return Math.max(result, temp + cur);
        }else {
            return Math.max(result,temp);
        }
    }

}
