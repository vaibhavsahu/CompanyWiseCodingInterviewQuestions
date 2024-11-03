package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
public class SubsequenceOfLengthKWithLargestSum {
    static int maxSum  = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] nums = {5, -2, 3, 8};
        int k = 2;

        System.out.println(Arrays.toString(findSubsequencesBruteForce(nums, k)));
        System.out.println(Arrays.toString(findSubsequencesOptimized(nums, k)));

    }

    public static int [] findSubsequencesBruteForce(int[] nums, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, nums, k, new ArrayList<>(), list);
        return list.get(0).stream().mapToInt(i -> i).toArray();
    }

    private static void backtrack( int index, int[] nums, int k, List<Integer> current, List<List<Integer>> list) {

        if (index > nums.length) {
            return;
        }

        if (current.size() == k) {
            List<Integer> ans = new ArrayList<>(current);
            int sum = ans.stream().mapToInt(Integer::intValue).sum();
            if(sum > maxSum) {
                maxSum = sum;
                if(!list.isEmpty()){
                   list.remove(list.size()-1);
                }
                list.add(ans);
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            if( current.size() <= k){
                backtrack(i + 1, nums, k, current, list);
            }
            current.remove(current.size()-1);
        }
    }

    public static int [] findSubsequencesOptimized(int[] nums, int k) {
        Integer[] indexes = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i; // Initialize with the original indexes
        }

        // Sort the indexes based on the values of nums in descending order
        Arrays.sort(indexes, (i, j) -> nums[j] - nums[i]);

        // Select the first k indexes
        int[] topKIndexes = Arrays.stream(indexes).limit(k).sorted().mapToInt(i -> i).toArray();

        // Construct the result using the selected indexes
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[topKIndexes[i]];
        }
        return result;
    }
}