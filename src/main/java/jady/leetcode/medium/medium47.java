package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author liuhan
 * @date 2020/06/24
 * https://leetcode-cn.com/problems/permutations-ii/
 * todo 未解决
 */
@Slf4j
public class medium47 {

    public static void main(String[] args) {
        log.info("result = {}",permuteUnique(new int[]{1,1,3,3,3,2,2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        return handle(list, map);
    }
    public static List<List<Integer>> handle(List<List<Integer>> list, Map<Integer, Integer> map){
        Map<Integer, Integer> map1 = new HashMap<>(map);
        List<List<Integer>> result = new ArrayList<>();
        if(list.isEmpty()){
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                List<Integer> subList = new ArrayList<>();
                subList.add(entry.getKey());
                entry.setValue(entry.getValue() - 1);
                list.add(subList);
                result.addAll(handle(list, map1));
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                for (List<Integer> subList : list) {
                    if(entry.getValue()>0){
                        subList.add(entry.getKey());
                        result.add(subList);
                        entry.setValue(entry.getValue() - 1);
                        return handle(result, map1);
                    }
                }
            }
        }
        return result;
    }

}
