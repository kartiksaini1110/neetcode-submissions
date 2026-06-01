class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            if(map.get(t.charAt(i)) != null){
                if(map.get(t.charAt(i)) == 1){
                    map.remove(t.charAt(i));
                }else{
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            }else{
                return false;
            }
        }

        return map.isEmpty();
    }
}
