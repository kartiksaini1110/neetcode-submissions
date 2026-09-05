class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for(int w : weights){
            max = Math.max(max, w);
            sum += w;
        }
        for(int cap=max; cap<=sum; cap++){
            if(canShip(weights, days, cap)){
                return cap;
            }
        }
        return sum;
    }
    public boolean canShip(int[] weights, int days, int cap){
        int d = 1;
        int curr = 0;
        for(int w : weights){
            if(curr + w > cap){
                d++;
                curr = w;
            }else{
                curr += w;
            }
        }
        return d <= days;
    }
}