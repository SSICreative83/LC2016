public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)    return "";
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while(i < j) {
            while(i < j && !set.contains(arr[i])) {
                i++;
            }
            while(i < j && !set.contains(arr[j])) {
                j--;
            }
            if(i < j) { //found
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
