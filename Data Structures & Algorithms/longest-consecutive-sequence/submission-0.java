class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int temp = 1;
        int max = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] == nums[i-1] + 1){
                temp++;
                max = Math.max(max, temp);
            }else{
                temp = 1;
            }
        }
        return max;
    }
}
