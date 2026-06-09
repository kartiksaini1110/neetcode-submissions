class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 0;
        for(Integer current : set){
            int prev = current - 1;
            if(!set.contains(prev)){
                int len = 1;
                int nextElement = current + 1;
                while(set.contains(nextElement)){
                    len++;
                    nextElement++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
