/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
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
}
