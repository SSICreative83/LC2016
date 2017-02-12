/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity1(int n) {
        
        //find the column where all values are 1
        
        if(n == 0)  return -1;
        for(int i = 0; i < n; i++) {
            int col = i;
            int j = 0;
            for(; j < n; j++) {
                if(!knows(j, col)) {
                    break;
                }
            }
            if(j == n) {  //found the column with all 1, check wether the row is all 0
                int k = 0;
                for(; k < n; k++) {
                    if(k != col && knows(col, k)) {
                        break;
                    }
                }
                if(k == n) {
                    return col;
                }
            }
        }
        return -1;
    }
    
    // smart way of selecting candidate
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
