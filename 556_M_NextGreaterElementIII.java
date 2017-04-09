public class Solution {
    public int nextGreaterElement(int n) {
        if(n <= 0) {
            return -1;
        }
        int len = 0;
        int nn = n;
        while(nn > 0 ) {
            len++;
            nn /= 10;
        }

        int[] num = new int[len];
        nn = n;
        int index = len - 1;
        while(nn > 0) {
            num[index] = nn % 10;
            nn /= 10;
            index--;
        }
        
        int len1 = num.length; 
        if(len1 == 0 || len1 == 1)    return -1;
        
        int firstNonInc = -1;
        boolean found = false;
        
        for(int i = len1 - 1; i > 0; i--){
            if(num[i] > num[i - 1]){
                firstNonInc = i - 1;
                found = true;
                break;
            }
        }
        
        if(!found){
            return -1;
        }
        long ret = 0;
        int[] res = nextPermutation(num);
        int newlen = res.length;
        for(int i = 0; i < newlen; i++) {
            ret = 10 * ret + res[i];
        }
        if(ret > Integer.MAX_VALUE) {
            return -1;
        } 

        return (int)ret;
    }
    
    public int[] nextPermutation(int[] num) {
        int len = num.length; 
        if(len == 0 || len == 1)    return null;
        
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
        
        for(int i = len - 1; i >= 0; i--){
            if(num[i] > num[firstNonInc]){
                firstBigger = i;
                break;
            }
        }
        
        swap(num, firstNonInc, firstBigger);
        
        reverse(num, firstNonInc + 1, len - 1);
        return num;
        
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
