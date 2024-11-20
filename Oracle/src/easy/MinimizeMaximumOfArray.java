package easy;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        int res = nums[0];
        int total = nums[0];

        for(var i = 1; i < nums.length; i++){
            total += nums[i];
            res = (int) Math.max(res, (total / (double)(i + 1)));
        }
        return res;
    }

    public int minimizeArrayValueBinarySearch(int[] nums) {
        int low  = nums[0];
        int high = nums[0];
        for(var num : nums){
            high = Math.max(high, num);
        }
        int ans = high;

        while(low <= high){
            int mid = (low + high) >>> 1;
            if(minPossible(nums, mid)){
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean minPossible(int[] nums, int mid) {
        long total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            if(total > (long)mid * (i + 1)){
                return false;
            }
        }
        return true;
    }

}
