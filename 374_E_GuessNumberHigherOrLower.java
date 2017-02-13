/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        if(n <= 0)  return -1;
        if(n == 1)  return 1;
        
        int start = 1, end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(guess(mid) == 0) {
                return mid;
            } else if(guess(mid) < 0) { //mid is larger, answer is in lower half
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        if(guess(end) == 0) {
            return end;
        }
        return start;
    }
}
