public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                int end = i - 1;
                reverse(arr, start, end);
                start = i + 1;
            } 
        }
        
        reverse(arr, start, s.length() - 1);
        return new String(arr);
    }
    
    public void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
