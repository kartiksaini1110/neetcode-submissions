class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer element : nums){
            if(set.contains(element)) return true;
            set.add(element);
        }
        return false;
    }
}