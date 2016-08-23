public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)    return true;
        char[] arr = s.trim().toCharArray();
        
        for(int i = 0, j = arr.length - 1; i <= j; i++, j--) {    //notice the for/while loop conditions
            while(!isValid(arr[i]) && i < arr.length - 1 && i < j) i++;
            while(!isValid(arr[j]) && j > 0 && i < j) j--;
            if(i > j || upper(arr[i]) != upper(arr[j])) return false;
        }
        
        return true;
    }
    
    public boolean isValid(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
    
    public char upper(char c) {
        if(c >= 'a' && c <= 'z') {
            c = (char)(c + ('A' - 'a'));
        }
        return c;
    }
}
