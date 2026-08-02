class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int maxFrequency = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(j)));
            if((j-i+1) - maxFrequency > k){
                char left = s.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
