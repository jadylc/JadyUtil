package jady.leetcode.weekly;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuhan
 * @date 2019/09/26
 */
@Slf4j
public class weekly5197 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,8,-10,23,19,-4,-14,27};
        log.info("result = {}",handle(arr));
    }
    private static List<List<Integer>> handle(Integer[] arr){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int minus = arr[i+1] -arr[i];
            if (minus < min){
                list = new ArrayList<>();
                List<Integer> tL = new ArrayList<>();
                tL.add(arr[i]);
                tL.add(arr[i+1]);
                list.add(tL);
                min = minus;
            }else if(minus == min){
                List<Integer> tL = new ArrayList<>();
                tL.add(arr[i]);
                tL.add(arr[i+1]);
                list.add(tL);
            }
        }
        return list;
    }
}
