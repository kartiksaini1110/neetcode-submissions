/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while(true){
            int mid1 = l + (r-l) / 3;
            int mid2 = r - (r-l) / 3;
            if(guess(mid1) == 0) return mid1;
            if(guess(mid2) == 0) return mid2;
            if(guess(mid1) + guess(mid2) == 0){
                l = mid1 + 1;
                r = mid2 - 1;
            }else if(guess(mid1) == -1){
                r = mid1 - 1;
            }else{
                l = mid2 + 1;
            }
        }
    }
}