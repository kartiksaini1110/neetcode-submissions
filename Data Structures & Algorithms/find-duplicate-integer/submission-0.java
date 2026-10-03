class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                ans = num;
            }else{
                map.put(num, 1);
            }
        }
        return ans;
    }
}
