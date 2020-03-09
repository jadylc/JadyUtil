package jady.leetcode.easy;

import jady.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author liuhan
 * @date 2019/09/26
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
@Slf4j
public class easy108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = handle(nums);
        log.info("result = {}",treeNode);
    }
    private static TreeNode handle(int[] nums){
        return handleTree(nums,0,nums.length-1);
    }
    private static TreeNode handleTree(int[] nums,int l, int r){
        if(l > r){
            return null;
        }
        int m = l+(r-l)/2;
        TreeNode head = new TreeNode(nums[m]);
        head.left = handleTree(nums,l,m-1);
        head.right = handleTree(nums,m+1,r);
        return head;
    }
}
