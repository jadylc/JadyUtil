package jady.leetcode.easy;

import jady.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author liuhan
 * @date 2020/06/23
 * https://leetcode-cn.com/problems/add-binary/
 */
@Slf4j
public class easy67 {

    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        String c = addBinary(a,b);
        log.info("result = {}",c);
    }

    public static String addBinary(String a, String b) {
        int temp = 0;
        char[] ac = a.toCharArray();
        int sizea = ac.length;
        char[] bc = b.toCharArray();
        int sizeb = bc.length;
        if(sizea == sizeb && sizea == 1){
            int total = Integer.parseInt(a) + Integer.parseInt(b);
            if(total < 2){
                return String.valueOf(total);
            }
            return "10";
        }
        char[] cc = new char[ Math.max(sizea, sizeb) +1];
        int sizec = cc.length;
        for (int i = 1; i <= sizec; i++) {
            if(i <= sizea && i<= sizeb) {
                int ai = ac[sizea - i];
                int bi = bc[sizeb - i];
                int total = ai + bi + temp - '0' - '0';
                if (total == 0) {
                    cc[sizec - i] = '0';
                } else if (total == 1) {
                    cc[sizec - i] = '1';
                    temp = 0;
                } else if (total == 2) {
                    cc[sizec - i] = '0';
                    temp = 1;
                } else if (total == 3) {
                    cc[sizec - i] = '1';
                    temp = 1;
                }
            }else if(i > sizea && i> sizeb){
                if(temp == 1){
                    cc[sizec - i] = '1';
                }
            }else if(i > sizea){
                int bi = bc[sizeb - i];
                int total = bi + temp - '0';
                if (total == 0) {
                    cc[sizec - i] = '0';
                } else if (total == 1) {
                    cc[sizec - i] = '1';
                    temp = 0;
                } else if (total == 2) {
                    cc[sizec - i] = '0';
                    temp = 1;
                }
            }else {
                int ai = ac[sizea - i];
                int total = ai + temp - '0';
                if (total == 0) {
                    cc[sizec - i] = '0';
                } else if (total == 1) {
                    cc[sizec - i] = '1';
                    temp = 0;
                } else if (total == 2) {
                    cc[sizec - i] = '0';
                    temp = 1;
                }
            }
        }
        String result = "";
        for (char c : cc) {
            if (c != 0){
                result += c;
            }
        }
        return result;
    }
}
