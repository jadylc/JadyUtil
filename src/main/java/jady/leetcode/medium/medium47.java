package jady.leetcode.medium;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author liuhan
 * @date 2020/06/24
 * https://leetcode-cn.com/problems/permutations-ii/
 */
@Slf4j
public class medium47 {

    public static void main(String[] args) {
        log.info("result = {}",permuteUnique(new int[]{1,1,3,3,3,2,2}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.forEach(k -> {
            List<Integer> subList = new ArrayList<>();
            subList.add(k);
            Map<Integer, Integer> remainMap = getRemainMap(map, k);
            List<List<Integer>> subResult = new ArrayList<>();
            subResult.add(subList);
            list.addAll(handle(subResult, remainMap));
        });
        return list;
    }

    public static List<List<Integer>> handle(List<List<Integer>> list, Map<Integer, Integer> map){
        if(map.isEmpty()){
            return list;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        list.forEach(s -> {
            keys.forEach(k -> {
                List<Integer> subList = new ArrayList<>(s);
                subList.add(k);
                Map<Integer, Integer> remainMap = getRemainMap(map, k);
                List<List<Integer>> subResult = new ArrayList<>();
                subResult.add(subList);
                result.addAll(handle(subResult, remainMap));
            });
        });
        return result;
    }

    public static Map<Integer, Integer> getRemainMap(Map<Integer, Integer> map,Integer k){
        Map<Integer, Integer> newMap = new HashMap<>(map);
        if (newMap.get(k) == 1) {
            newMap.remove(k);
        }else {
            newMap.put(k, map.get(k) -1);
        }
        return newMap;
    }



}
