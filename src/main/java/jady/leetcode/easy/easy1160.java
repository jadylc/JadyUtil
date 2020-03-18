package jady.leetcode.easy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuhan on 2020/3/17.
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
@Slf4j
public class easy1160 {
    public static void main(String[] args) {
        String[] words = new String[]{"cat","bt","hat","tree"};
        log.info("result = {}",countCharacters(words,"atach"));
    }
    public static int countCharacters(String[] words, String chars) {
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = chars.toCharArray();
        for (char c : cs) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }
        for (String word : words) {
            Map<Character, Integer> map1 = new HashMap<>(map);
            char[] w = word.toCharArray();
            int l = w.length;
            boolean b = true;
            for (char c : w) {
                Integer count = map1.get(c);
                if(count!=null){
                    if(count - 1>0){
                        map1.put(c, count -1);
                    }else {
                        map1.remove(c);
                    }
                }else {
                    b = false;
                    break;
                }
            }
            if(b){
                r+=l;
            }
        }
        return r;
    }
}
