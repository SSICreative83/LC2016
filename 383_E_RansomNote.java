public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            int cur = magazine.charAt(i) - 'a';
            count[cur]++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            int cur = ransomNote.charAt(i) - 'a';
            count[cur]--;
            if(count[cur] < 0)  {
                return false;
            }
        }
        
        return true;
    }
}
