package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuhan
 * @date 2020/03/07
 * https://leetcode-cn.com/problems/words-frequency-lcci/
 */
@Slf4j
public class medium100259 {
    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        log.info("result = {}",wordsFrequency.get("you"));
        log.info("result = {}",wordsFrequency.get("an"));
        log.info("result = {}",wordsFrequency.get("have"));

    }

    static class WordsFrequency{
        Map<Character,Item> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                Map<Character,Item> cMap = map;
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char aChar = chars[i];
                    if (!cMap.containsKey(aChar)) {
                        Item item = new Item();
                        item.c = aChar;
                        item.child = new HashMap<>();
                        cMap.put(aChar, item);
                    }
                    if(i == chars.length-1){
                        cMap.get(aChar).t += 1;
                    }else {
                        cMap = cMap.get(aChar).child;
                    }
                }

            }
        }

        public int get(String word) {
            int result = 0;
            char[] chars = word.toCharArray();
            Map<Character, Item> temp = map;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];

                Item item = temp.get(aChar);
                if (item != null) {
                    if(i == chars.length-1){
                        result = item.t;
                    }
                    if (item.child != null) {
                        temp = item.child;
                    }
                }else {
                    break;
                }
            }
            return result;
        }
    }
    static class Item {
        Character c;
        int t;
        Map<Character,Item> child;
    }
}
