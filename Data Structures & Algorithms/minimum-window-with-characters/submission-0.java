class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        int uniqueCharCount = map.size();
        int startIndex = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int minLength = Integer.MAX_VALUE;
        int N = s.length();
        while(windowEnd < N){
            char ch = s.charAt(windowEnd);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0){
                    uniqueCharCount--;
                }
            }
            while(uniqueCharCount == 0){
                int len = windowEnd - windowStart + 1;
                if(len < minLength){
                    minLength = len;
                    startIndex = windowStart;
                }
                ch = s.charAt(windowStart);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) > 0){
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }
        if(startIndex == -1){
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}
