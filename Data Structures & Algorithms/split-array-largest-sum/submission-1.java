class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;

        for(int value : nums){
            sum += value;
            max = Math.max(value, max);
        }

        if(k == nums.length){
            return max;
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while(low <= high){
            int mid = low + (high-low) / 2;
            if(isPossible(nums, mid, k)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] nums, int mid, int k){
        int count = 1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                count++;
                sum = nums[i];
            }
        }
        return count <= k;
    }
}