public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length; 
        if(len == 0 || len == 1)    return;
        
        int firstNonInc = -1;
        int firstBigger = -1;
        boolean found = false;
        
        for(int i = len - 1; i > 0; i--){
            if(num[i] > num[i - 1]){
                firstNonInc = i - 1;
                found = true;
                break;
            }
        }
        
        if(!found){
            reverse(num, 0, len - 1);
            return;
        }
        
        for(int i = len - 1; i >= 0; i--){
            if(num[i] > num[firstNonInc]){
                firstBigger = i;
                break;
            }
        }
        
        swap(num, firstNonInc, firstBigger);
        
        reverse(num, firstNonInc + 1, len - 1);
        
        
    }
    
    public void reverse(int[] num, int start, int end){
        while(start < end){
            swap(num, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
