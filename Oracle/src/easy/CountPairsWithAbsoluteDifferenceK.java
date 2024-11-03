package easy;

import java.util.HashMap;
//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
public class CountPairsWithAbsoluteDifferenceK {
    public static int countPairsWithAbsoluteDifferenceBruteForce(int [] nums, int k) {
        if (nums == null || nums.length == 0) { return 0;}
        var count = 0;
        for(var i = 0; i < nums.length; i++) {
            for (var j = i+1; j < nums.length; j++) {
                if(Math.abs(nums[i]-nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countPairsWithAbsoluteDifferenceOptimized(int [] nums, int k) {
        if (nums == null || nums.length == 0) { return 0;}
        var count = 0;
        var map = new HashMap<Integer, Integer>();
        for(var num : nums) {
             count += map.getOrDefault(num-k, 0)+map.getOrDefault(num+k, 0);
             map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPairsWithAbsoluteDifferenceOptimized(new int[]{1,3,4,5,2}, 2));
    }
}
