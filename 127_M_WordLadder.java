public class Solution {
    //BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        
        int len = beginWord.length();
        Set<String> dict = new HashSet<>();
        for(String s : wordList) {
            dict.add(s);
        }
        
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> lenqueue = new LinkedList<>();
        queue.offer(beginWord);
        lenqueue.offer(1);
        
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            int curLen = lenqueue.poll();
            if(cur.equals(endWord)) {
                return curLen;
            }
            
            for(int i = 0; i < len; i++) {
                char[] curArr = cur.toCharArray();
                char curChar = cur.charAt(i);
                for(int j = 0; j < 26; j++) {
                    if((char)('a' + j) == curChar) {
                        continue;
                    } 
                    curArr[i] = (char)('a' + j);
                    String newWord = new String(curArr);
                    if(dict.contains(newWord)) {
                        queue.offer(newWord);
                        lenqueue.offer(curLen + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
